import os
import glob
import shutil
from subprocess import CalledProcessError, check_output, check_call

raw_path = "/Users/lizbai/Documents/COMP2021/assignment-1/raw"
tmp_path = "/Users/lizbai/Documents/COMP2021/assignment-1/tmp"
data_path = "/Users/lizbai/Documents/COMP2021/assignment-1/data"

# copy files from raw folder to each folder with the name of student id
id_list = []
os.chdir(raw_path)
for f in glob.glob("*.txt"):
    id = f.split('_')[1]
    real_folder = os.path.join(tmp_path, id)
    if not os.path.exists(real_folder):
        os.makedirs(real_folder)
    for name in glob.glob('*' + id + '*'):
        shutil.copy(name, real_folder)
    id_list.append(id)

# decompress the zip, rar and 7z files into a temporary directory
for root, dirs, files in os.walk(tmp_path):
    files = [f for f in files if not f[0] == '.']
    dirs[:] = [d for d in dirs if not d[0] == '.']
    for f in files:
        if os.path.splitext(f)[1] == '.zip':
            f = '"' + f + '"'
            root = '"' + root + '"'
            check_call("cd " + root + "; unzip " + f + "; rm -rf " + f, shell=True)
        if os.path.splitext(f)[1] == '.rar':
            f = '"' + f + '"'
            root = '"' + root + '"'
            check_call("cd " + root + "; unrar e -o+ " + f + "; rm -rf " + f, shell=True)
        if os.path.splitext(f)[1] == '.7z':
            f = '"' + f + '"'
            root = '"' + root + '"'
            check_call("cd " + root + "; 7za e " + f + "; rm -rf " + f, shell=True)

# copy all the files we need into a new directory with the folder name of student id
pat_list = ["MiniFloat.java"]
for id in id_list:
    final_folder = os.path.join(data_path, id)
    if not os.path.exists(final_folder):
        os.makedirs(final_folder)
    for root, dirs, files in os.walk(os.path.join(tmp_path, id)):
        for f in files:
            # copy the text file into destination folder
            if f.startswith('Assignment') and f.endswith('.txt'):
                shutil.copyfile(os.path.join(root, f), os.path.join(final_folder, f))
            # copy the files we need
            for pat in pat_list:
                if f.endswith(pat) and not f.startswith('.'):
                    shutil.copyfile(os.path.join(root, f), os.path.join(final_folder, pat))

# Until now, we get clean files we need to test.
# We can use another python file to grade all files.









