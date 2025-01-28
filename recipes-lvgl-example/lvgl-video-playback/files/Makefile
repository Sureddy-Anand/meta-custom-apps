
# Compiler and Flags
CC = $(TARGET_CC)
#CFLAGS = -I. -I$(includedir)/lvgl -I$(includedir)/lvgl/lv_drivers -O2 -Wall -DLV_CONF_INCLUDE_SIMPLE
#LDFLAGS = -L$(libdir) -llvgl -llv_drivers -lwayland-client

CFLAGS += -I. -I$(includedir)/lvgl -I$(includedir)/lvgl/lv_drivers -O2 -Wall -DLV_CONF_INCLUDE_SIMPLE
CFLAGS += -I$(includedir)/gstreamer-1.0 -I$(includedir)/glib-2.0 -I$(includedir)/../../usr/lib64/glib-2.0/include
LDFLAGS = -L$(libdir) -llvgl -llv_drivers -lwayland-client -lgstreamer-1.0 -lglib-2.0 -lgobject-2.0 -lpthread

# Output executable
TARGET = lvgl_sample_video_playback

# Directories
SRCDIR = ./src
BUILD_DIR = build
OBJDIR = $(BUILD_DIR)/src
OBJDIR_MATERIAL = $(BUILD_DIR)/src/material

# Source files
SRCS = $(wildcard $(SRCDIR)/*.c $(SRCDIR)/material/*.c)
OBJS = $(patsubst $(SRCDIR)/%.c, $(OBJDIR)/%.o, $(SRCS))

# Default target
all: $(BUILD_DIR)/$(TARGET)

# Rule to create the build directories if they don't exist
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

$(OBJDIR):
	mkdir -p $(OBJDIR)

$(OBJDIR_MATERIAL):
	mkdir -p $(OBJDIR_MATERIAL)

# Link the final binary
$(BUILD_DIR)/$(TARGET): $(OBJS) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -o $@ $^ $(LDFLAGS)

# Compile source files into the build directory
$(OBJDIR)/%.o: $(SRCDIR)/%.c | $(OBJDIR)
	$(CC) $(CFLAGS) -c -o $@ $<

$(OBJDIR_MATERIAL)/%.o: $(SRCDIR)/material/%.c | $(OBJDIR_MATERIAL)
	$(CC) $(CFLAGS) -c -o $@ $<

# Clean target
clean:
	rm -rf $(BUILD_DIR)


