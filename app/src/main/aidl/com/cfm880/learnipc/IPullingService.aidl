// IPullingService.aidl
package com.cfm880.learnipc;

// Declare any non-default types here with import statements
import com.cfm880.learnipc.ICallback;

interface IPullingService {
   void getLastNews();
   void registerListener(ICallback listener);
   void unregisterListener(ICallback listener);
}
