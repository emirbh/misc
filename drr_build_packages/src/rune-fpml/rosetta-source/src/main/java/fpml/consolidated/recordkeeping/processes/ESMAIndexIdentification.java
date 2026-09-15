package fpml.consolidated.recordkeeping.processes;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.fpmlenum.ESMABenchmarkIndexCode;
import fpml.consolidated.recordkeeping.processes.meta.ESMAIndexIdentificationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ESMAIndexIdentification", builder=ESMAIndexIdentification.ESMAIndexIdentificationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ESMAIndexIdentification", model="fpml", builder=ESMAIndexIdentification.ESMAIndexIdentificationBuilderImpl.class, version="2.1.1")
public interface ESMAIndexIdentification extends RosettaModelObject {

	ESMAIndexIdentificationMeta metaData = new ESMAIndexIdentificationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ESMABenchmarkIndexCode getCode();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getName();

	/*********************** Build Methods  ***********************/
	ESMAIndexIdentification build();
	
	ESMAIndexIdentification.ESMAIndexIdentificationBuilder toBuilder();
	
	static ESMAIndexIdentification.ESMAIndexIdentificationBuilder builder() {
		return new ESMAIndexIdentification.ESMAIndexIdentificationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ESMAIndexIdentification> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ESMAIndexIdentification> getType() {
		return ESMAIndexIdentification.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("code"), ESMABenchmarkIndexCode.class, getCode(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ESMAIndexIdentificationBuilder extends ESMAIndexIdentification, RosettaModelObjectBuilder {
		ESMAIndexIdentification.ESMAIndexIdentificationBuilder setCode(ESMABenchmarkIndexCode code);
		ESMAIndexIdentification.ESMAIndexIdentificationBuilder setName(String name);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("code"), ESMABenchmarkIndexCode.class, getCode(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		}
		

		ESMAIndexIdentification.ESMAIndexIdentificationBuilder prune();
	}

	/*********************** Immutable Implementation of ESMAIndexIdentification  ***********************/
	class ESMAIndexIdentificationImpl implements ESMAIndexIdentification {
		private final ESMABenchmarkIndexCode code;
		private final String name;
		
		protected ESMAIndexIdentificationImpl(ESMAIndexIdentification.ESMAIndexIdentificationBuilder builder) {
			this.code = builder.getCode();
			this.name = builder.getName();
		}
		
		@Override
		@RosettaAttribute("code")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("code")
		public ESMABenchmarkIndexCode getCode() {
			return code;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		public ESMAIndexIdentification build() {
			return this;
		}
		
		@Override
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder toBuilder() {
			ESMAIndexIdentification.ESMAIndexIdentificationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ESMAIndexIdentification.ESMAIndexIdentificationBuilder builder) {
			ofNullable(getCode()).ifPresent(builder::setCode);
			ofNullable(getName()).ifPresent(builder::setName);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAIndexIdentification _that = getType().cast(o);
		
			if (!Objects.equals(code, _that.getCode())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (code != null ? code.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAIndexIdentification {" +
				"code=" + this.code + ", " +
				"name=" + this.name +
			'}';
		}
	}

	/*********************** Builder Implementation of ESMAIndexIdentification  ***********************/
	class ESMAIndexIdentificationBuilderImpl implements ESMAIndexIdentification.ESMAIndexIdentificationBuilder {
	
		protected ESMABenchmarkIndexCode code;
		protected String name;
		
		@Override
		@RosettaAttribute("code")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("code")
		public ESMABenchmarkIndexCode getCode() {
			return code;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@RosettaAttribute("code")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("code")
		@Override
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder setCode(ESMABenchmarkIndexCode _code) {
			this.code = _code == null ? null : _code;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@Override
		public ESMAIndexIdentification build() {
			return new ESMAIndexIdentification.ESMAIndexIdentificationImpl(this);
		}
		
		@Override
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCode()!=null) return true;
			if (getName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ESMAIndexIdentification.ESMAIndexIdentificationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ESMAIndexIdentification.ESMAIndexIdentificationBuilder o = (ESMAIndexIdentification.ESMAIndexIdentificationBuilder) other;
			
			
			merger.mergeBasic(getCode(), o.getCode(), this::setCode);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ESMAIndexIdentification _that = getType().cast(o);
		
			if (!Objects.equals(code, _that.getCode())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (code != null ? code.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ESMAIndexIdentificationBuilder {" +
				"code=" + this.code + ", " +
				"name=" + this.name +
			'}';
		}
	}
}
