# utils.junit
JUnit helpers and extensions
 
## Setup
```xml
<dependency>      
     <groupId>com.zandero</groupId>      
     <artifactId>utils.junit</artifactId>      
     <version>0.2</version>
     <scope>test</scope>      
</dependency>
```

## Usage

### Make sure final classes are well defined

- checks class is final 
- checks class has only one private constructor
- checks methods are static

```java

    @Test
    public void checkDefinition() {
        AssertFinalClass.isWellDefined(FinalClass.class);
    }
```

