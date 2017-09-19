LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := MyLibrary
LOCAL_SRC_FILES =: native_lib.cpp
include $(BUILD_SHARED_LIBRARY)
