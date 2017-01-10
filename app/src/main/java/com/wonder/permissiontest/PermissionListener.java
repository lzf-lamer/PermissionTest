package com.wonder.permissiontest;

import java.util.List;

/**
 * Created by wonder on 2016/12/28.
 */

public interface PermissionListener {
    void granted();
    void denied(List<String> deniedPermission);
}
