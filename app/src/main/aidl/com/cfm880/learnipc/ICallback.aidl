// ICallback.aidl
package com.cfm880.learnipc;

// Declare any non-default types here with import statements
import com.cfm880.learnipc.datasource.entity.NewsList;
interface ICallback {
    void getData(in NewsList newsList);
}
