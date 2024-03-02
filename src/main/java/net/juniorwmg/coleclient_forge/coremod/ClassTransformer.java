package net.juniorwmg.coleclient_forge.coremod;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.*;

public class ClassTransformer implements IClassTransformer {

    public byte[] transform(final String name, final String transformedName, final byte[] basicClass) {
        if (name.equals("net.minecraftforge.fml.client.SplashProgress")) {
            final ClassNode classNode = new ClassNode();
            final ClassReader classReader = new ClassReader(basicClass);
            classReader.accept(classNode, 0);
            for (final MethodNode methodNode : classNode.methods)
                if (methodNode.name.equals("start"))
                    for (final  AbstractInsnNode insnNode : methodNode.instructions.toArray() ){
                        if (insnNode instanceof LdcInsnNode) {
                            final LdcInsnNode ldcInsnNode = (LdcInsnNode)insnNode;
                            if (ldcInsnNode.cst.equals("textures/gui/title/mojang.png")) {
                                ldcInsnNode.cst = "coleclient_forge:textures/gui/title/mojang.png";
                                break;
                            }
                            System.out.println("TITLE IMAGE CHANGE CODE EXECUTED.");
                        }
                    }
            final ClassWriter writer = new ClassWriter(3);
            classNode.accept(writer);
            return writer.toByteArray();
        }
        return basicClass;
    }
}