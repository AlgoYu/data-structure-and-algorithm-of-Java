/*
哈夫曼编码：哈夫曼编码是一种可变字长编码(VLC)的一种算法，利用数据出现的概率构建哈夫曼树以获取异字头码字，也称为最佳编码。
主要思想：
	1. 使用HashMap统计字节出现的数量。
	2. 使用统计的数字构建哈弗曼树。
	3. 遍历哈弗曼树获取每个叶子节点存储字节的哈夫曼编码，往左为0，往右为1。
	4. 拼接哈夫曼编码，并以每8位存放为一个字节。
	5. 解压为逆向操作。
*/
package cn.machine.geek.algorithm.compression;

import java.io.*;
import java.util.*;

public class HuffmanCoding {
    private Map<Byte, String> huffmanCoding;

    public HuffmanCoding() {
        this.huffmanCoding = new HashMap<>();
    }

    public class HuffmanCodingNode implements Comparable<HuffmanCodingNode> {
        private Byte data;
        private int weight;
        private HuffmanCodingNode left;
        private HuffmanCodingNode right;

        public HuffmanCodingNode(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        public Byte getData() {
            return data;
        }

        public void setData(Byte data) {
            this.data = data;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public HuffmanCodingNode getLeft() {
            return left;
        }

        public void setLeft(HuffmanCodingNode left) {
            this.left = left;
        }

        public HuffmanCodingNode getRight() {
            return right;
        }

        public void setRight(HuffmanCodingNode right) {
            this.right = right;
        }

        @Override
        public int compareTo(HuffmanCodingNode o) {
            return this.weight - o.getWeight();
        }
    }

    // Huffman变长字节编码
    public byte[] huffmanCompression(byte[] data) {
        HuffmanCodingNode huffmanTree = this.createHuffmanTree(data);
        this.createHuffmanCoding(huffmanTree, "", new StringBuilder());
        StringBuilder temp = new StringBuilder();
        for (byte value : data) {
            temp.append(this.huffmanCoding.get(value));
        }
        byte[] huffmanCode = new byte[(temp.length() + 15) / 8];
        int index = 0;
        for (int i = 0; i < temp.length(); i += 8) {
            if (i + 8 > temp.length()) {
                huffmanCode[index] = (byte) Integer.parseInt(temp.substring(i), 2);
                huffmanCode[index + 1] = (byte) temp.substring(i).length();
            } else {
                huffmanCode[index] = (byte) Integer.parseInt(temp.substring(i, i + 8), 2);
            }
            index++;
        }
        return huffmanCode;
    }

    // 创建哈夫曼编码
    public void createHuffmanCoding(HuffmanCodingNode node, String code, StringBuilder stringBuilder) {
        if (node != null) {
            StringBuilder temp = new StringBuilder(stringBuilder);
            temp.append(code);
            if (node.getData() != null) {
                this.huffmanCoding.put(node.getData(), temp.toString());
            } else {
                this.createHuffmanCoding(node.getLeft(), "0", temp);
                this.createHuffmanCoding(node.getRight(), "1", temp);
            }
        }
    }

    // 创建哈弗曼树
    public HuffmanCodingNode createHuffmanTree(byte[] bytes) {
        List<HuffmanCodingNode> nodes = this.createNode(bytes);
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HuffmanCodingNode left = nodes.get(0);
            HuffmanCodingNode right = nodes.get(1);
            HuffmanCodingNode parent = new HuffmanCodingNode(null, left.getWeight() + right.getWeight());
            parent.setLeft(left);
            parent.setRight(right);
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    // 获取字节节点
    public List<HuffmanCodingNode> createNode(byte[] bytes) {
        Map<Byte, Integer> count = new HashMap<>();
        List<HuffmanCodingNode> nodes = new ArrayList<>();
        for (byte value : bytes) {
            Integer total = count.get(value);
            if (total == null) {
                count.put(value, 1);
            } else {
                count.put(value, total + 1);
            }
        }
        for (Map.Entry<Byte, Integer> map : count.entrySet()) {
            nodes.add(new HuffmanCodingNode(map.getKey(), map.getValue()));
        }
        return nodes;
    }

    // 字节转换为字符串
    public String byteConvertToString(byte data, boolean flag, int count) {
        int temp = data;
        temp |= 256;
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str.substring(str.length() - count);
        }
    }

    // Huffman变长字节解码
    public byte[] huffmanDecompression(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length - 1; i++) {
            if (i == bytes.length - 2) {
                stringBuilder.append(this.byteConvertToString(bytes[i], i < bytes.length - 2, bytes[bytes.length - 1]));
                break;
            }
            stringBuilder.append(this.byteConvertToString(bytes[i], i < bytes.length - 2, 0));
        }
        Map<String, Byte> deHuffmanCoding = new HashMap<>();
        for (Map.Entry<Byte, String> map : this.huffmanCoding.entrySet()) {
            deHuffmanCoding.put(map.getValue(), map.getKey());
        }
        List<Byte> byteList = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            while (true) {
                String key = stringBuilder.substring(i, i + count);
                Byte data = deHuffmanCoding.get(key);
                if (data != null) {
                    byteList.add(data);
                    break;
                }
                count++;
            }
            i += count;
        }
        byte[] data = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            data[i] = byteList.get(i);
        }
        return data;
    }

    // 哈夫曼压缩文件
    public void huffmanCompressionFile(String inputPath, String outputPath) {
        FileInputStream fileInputStream = null;
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileInputStream = new FileInputStream(inputPath);
            byte[] data = new byte[fileInputStream.available()];
            fileInputStream.read(data);
            byte[] huffmanBytes = this.huffmanCompression(data);
            File file = new File(outputPath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            outputStream = new FileOutputStream(outputPath);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(huffmanBytes);
            objectOutputStream.writeObject(this.huffmanCoding);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 哈夫曼解压文件
    public void huffmanDecompressionFile(String inputPath, String outputPath) {
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = new FileInputStream(inputPath);
            objectInputStream = new ObjectInputStream(inputStream);
            byte[] huffmanBytes = (byte[]) objectInputStream.readObject();
            this.huffmanCoding = (Map<Byte, String>) objectInputStream.readObject();
            byte[] sourceBytes = this.huffmanDecompression(huffmanBytes);
            File file = new File(outputPath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(outputPath);
            fileOutputStream.write(sourceBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 打印哈夫曼编码
    public void printHuffmanCoding() {
        for (Map.Entry<Byte, String> map : this.huffmanCoding.entrySet()) {
            System.out.println("key=" + map.getKey() + " value=" + map.getValue());
        }
    }
}