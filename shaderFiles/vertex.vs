#version 330

layout (location=0) in vec2 position;

void main()
{
	gl_Position = vec3(position, 1.0);
}
