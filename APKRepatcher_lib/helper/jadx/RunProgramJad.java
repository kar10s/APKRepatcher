package jadx;

import java.io.File;
import jadx.api.JadxArgs;
import jadx.api.JadxDecompiler;
import jadx.core.utils.exceptions.JadxException;

public class RunProgramJad {

	/**
	 * @param args
	 * @throws JadxException 
	 */
	public static void main(String[] args) throws JadxException {
		// TODO Auto-generated method stub
		if(args[0].equals("jadx")) {
			decompileJar2Java(new File(args[1]), args[2], args[3]);
		}
	}
	
	public static void decompileJar2Java(File jarPath, String outputSourceDirectory, String deobfuscate) throws JadxException {
		JadxArgs args = new JadxArgs();
		args.getInputFiles().add(jarPath);
		args.setOutDir(new File(outputSourceDirectory));
		args.setDeobfuscationOn(deobfuscate == "deobfuscate");

		JadxDecompiler jadx = new JadxDecompiler(args);
		jadx.load();
		jadx.save();

		if (jadx.getErrorsCount() != 0) {
			jadx.printErrorsReport();
		}
	}

}
