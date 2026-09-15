package fpml.consolidated;

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
import fpml.consolidated.meta.MgmtDataMeta;
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
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="MgmtData", builder=MgmtData.MgmtDataBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MgmtData", model="fpml", builder=MgmtData.MgmtDataBuilderImpl.class, version="2.1.1")
public interface MgmtData extends RosettaModelObject {

	MgmtDataMeta metaData = new MgmtDataMeta();

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

	/*********************** Build Methods  ***********************/
	MgmtData build();
	
	MgmtData.MgmtDataBuilder toBuilder();
	
	static MgmtData.MgmtDataBuilder builder() {
		return new MgmtData.MgmtDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MgmtData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MgmtData> getType() {
		return MgmtData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MgmtDataBuilder extends MgmtData, RosettaModelObjectBuilder {
		MgmtData.MgmtDataBuilder setValue(String value);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		}
		

		MgmtData.MgmtDataBuilder prune();
	}

	/*********************** Immutable Implementation of MgmtData  ***********************/
	class MgmtDataImpl implements MgmtData {
		private final String value;
		
		protected MgmtDataImpl(MgmtData.MgmtDataBuilder builder) {
			this.value = builder.getValue();
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
		public MgmtData build() {
			return this;
		}
		
		@Override
		public MgmtData.MgmtDataBuilder toBuilder() {
			MgmtData.MgmtDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MgmtData.MgmtDataBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MgmtData _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MgmtData {" +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of MgmtData  ***********************/
	class MgmtDataBuilderImpl implements MgmtData.MgmtDataBuilder {
	
		protected String value;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MgmtData.MgmtDataBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@Override
		public MgmtData build() {
			return new MgmtData.MgmtDataImpl(this);
		}
		
		@Override
		public MgmtData.MgmtDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MgmtData.MgmtDataBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MgmtData.MgmtDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MgmtData.MgmtDataBuilder o = (MgmtData.MgmtDataBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MgmtData _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MgmtDataBuilder {" +
				"value=" + this.value +
			'}';
		}
	}
}
