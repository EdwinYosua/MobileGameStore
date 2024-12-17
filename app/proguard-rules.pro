##---------------Begin: proguard configuration for SQLCipher  ----------
-keep,includedescriptorclasses class net.sqlcipher.** { *; }
-keep,includedescriptorclasses interface net.sqlcipher.** { *; }
##---------------End: proguard configuration for SQLCipher  ----------

# Existing rules
-keep class com.edwinyosua.** { *; }
-keepattributes *Annotation*

# Keep the Resource class and its inner classes
-keepclassmembers class com.edwinyosua.core.data.remote.network.ApiResponse {*;}

# Alternatively, keep all inner classes of Resource
-keep,allowobfuscation class com.edwinyosua.core.data.ApiResponse$* {*;}

-keep class kotlin.** { *; }
-keepclassmembers class kotlin.** { *; }
-dontwarn kotlin.**

-keep class androidx.viewbinding.** { *; }
-keepclassmembers class androidx.viewbinding.** { *; }
-dontwarn androidx.viewbinding.**

