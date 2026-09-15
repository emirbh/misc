package fpml.consolidated.shared;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.shared.meta.ResourceIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for resource identifiers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for resource identifiers.
 *
 */
@RosettaDataType(value="ResourceId", builder=ResourceId.ResourceIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResourceId", model="fpml", builder=ResourceId.ResourceIdBuilderImpl.class, version="2.1.1")
public interface ResourceId extends RosettaModelObject {

	ResourceIdMeta metaData = new ResourceIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getResourceIdScheme();

	/*********************** Build Methods  ***********************/
	ResourceId build();
	
	ResourceId.ResourceIdBuilder toBuilder();
	
	static ResourceId.ResourceIdBuilder builder() {
		return new ResourceId.ResourceIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResourceId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResourceId> getType() {
		return ResourceId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("resourceIdScheme"), String.class, getResourceIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResourceIdBuilder extends ResourceId, RosettaModelObjectBuilder {
		ResourceId.ResourceIdBuilder setValue(String value);
		ResourceId.ResourceIdBuilder setResourceIdScheme(String resourceIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("resourceIdScheme"), String.class, getResourceIdScheme(), this);
		}
		

		ResourceId.ResourceIdBuilder prune();
	}

	/*********************** Immutable Implementation of ResourceId  ***********************/
	class ResourceIdImpl implements ResourceId {
		private final String value;
		private final String resourceIdScheme;
		
		protected ResourceIdImpl(ResourceId.ResourceIdBuilder builder) {
			this.value = builder.getValue();
			this.resourceIdScheme = builder.getResourceIdScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("resourceIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resourceIdScheme")
		public String getResourceIdScheme() {
			return resourceIdScheme;
		}
		
		@Override
		public ResourceId build() {
			return this;
		}
		
		@Override
		public ResourceId.ResourceIdBuilder toBuilder() {
			ResourceId.ResourceIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResourceId.ResourceIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getResourceIdScheme()).ifPresent(builder::setResourceIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResourceId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(resourceIdScheme, _that.getResourceIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (resourceIdScheme != null ? resourceIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceId {" +
				"value=" + this.value + ", " +
				"resourceIdScheme=" + this.resourceIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of ResourceId  ***********************/
	class ResourceIdBuilderImpl implements ResourceId.ResourceIdBuilder {
	
		protected String value;
		protected String resourceIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("resourceIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("resourceIdScheme")
		public String getResourceIdScheme() {
			return resourceIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ResourceId.ResourceIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("resourceIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("resourceIdScheme")
		@Override
		public ResourceId.ResourceIdBuilder setResourceIdScheme(String _resourceIdScheme) {
			this.resourceIdScheme = _resourceIdScheme == null ? null : _resourceIdScheme;
			return this;
		}
		
		@Override
		public ResourceId build() {
			return new ResourceId.ResourceIdImpl(this);
		}
		
		@Override
		public ResourceId.ResourceIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResourceId.ResourceIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getResourceIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResourceId.ResourceIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResourceId.ResourceIdBuilder o = (ResourceId.ResourceIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getResourceIdScheme(), o.getResourceIdScheme(), this::setResourceIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResourceId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(resourceIdScheme, _that.getResourceIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (resourceIdScheme != null ? resourceIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResourceIdBuilder {" +
				"value=" + this.value + ", " +
				"resourceIdScheme=" + this.resourceIdScheme +
			'}';
		}
	}
}
