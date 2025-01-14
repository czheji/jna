Direct Mapping
==============

JNA supports a direct mapping method which can improve performance substantially, 
approaching that of custom JNI. Method signatures are the same as they would be 
in a JNA interface mapping, but they can be any static or object methods. You 
only need register them within the static initializer of the defining class,
as in the example below. The `Native.register()` method takes the name of your 
native library, the same as `Native.load()` would.

```java
import com.sun.jna.*;import com.zcsmart.jna.Native;import com.zcsmart.jna.Platform;

public class HelloWorld {
            
    public static native double cos(double x);
    public static native double sin(double x);
    
    static {
        Native.register(Platform.C_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        System.out.println("cos(0)=" + cos(0));
        System.out.println("sin(0)=" + sin(0));
    }
}
```

Direct mapping supports the same type mappings as interface mapping, except for 
arrays of `Pointer`/`Structure`/`String`/`WString`/`NativeMapped` as function 
arguments. In addition, direct mapping does not support NIO Buffers or 
primitive arrays as types returned by type mappers or `NativeMapped`. In addition
the primitive wrapper classes can only be used if a custom `TypeMapper` is used.
See the `DirectArgumentsWrappersMarshalTest` unittest for a sample. As using
the wrapper classes always incurs overhead and direct mapping is used for
performance improvement, this is deemed appropriate.W

**Varargs are not supported**.

Methods may be either static or member methods; the class or object is ignored on the native side.

You can easily convert from interface mapping to direct mapping by creating a 
direct mapping class which implements your library interface, with all methods 
defined as native methods. Then your library instance variable can be assigned 
an instance of this new class instead of the object returned by `Native.load()`.

If you are using a profiler which rewrites native methods, you may need to
set the system property `jna.profiler.prefix` to the prefix used by the
profiler to avoid linkage errors when binding to native methods.
