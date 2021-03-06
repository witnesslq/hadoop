package org.bigdata.util;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.SequenceFile.Reader.Option;
import org.apache.hadoop.io.Text;


public class test05 {
	public static void main(String[] args) throws IOException{
		Configuration config = HadoopConfig.getConfig();
		Path path = new Path("/seq.dat");
		Option optPath = SequenceFile.Reader.file(path);
		SequenceFile.Reader reader = new SequenceFile.Reader(config, optPath);
		IntWritable key = new IntWritable();
		Text value = new Text();
		while(reader.next(key,value)){
			System.out.println("key --> "+key.get()+" value --> "+value.toString()+" ");
		}
		reader.close();
	}
	
}
