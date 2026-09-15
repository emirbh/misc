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
import fpml.consolidated.shared.meta.MasterAgreementVersionMeta;
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
@RosettaDataType(value="MasterAgreementVersion", builder=MasterAgreementVersion.MasterAgreementVersionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MasterAgreementVersion", model="fpml", builder=MasterAgreementVersion.MasterAgreementVersionBuilderImpl.class, version="2.1.1")
public interface MasterAgreementVersion extends RosettaModelObject {

	MasterAgreementVersionMeta metaData = new MasterAgreementVersionMeta();

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
	String getMasterAgreementVersionScheme();

	/*********************** Build Methods  ***********************/
	MasterAgreementVersion build();
	
	MasterAgreementVersion.MasterAgreementVersionBuilder toBuilder();
	
	static MasterAgreementVersion.MasterAgreementVersionBuilder builder() {
		return new MasterAgreementVersion.MasterAgreementVersionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementVersion> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreementVersion> getType() {
		return MasterAgreementVersion.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("masterAgreementVersionScheme"), String.class, getMasterAgreementVersionScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementVersionBuilder extends MasterAgreementVersion, RosettaModelObjectBuilder {
		MasterAgreementVersion.MasterAgreementVersionBuilder setValue(String value);
		MasterAgreementVersion.MasterAgreementVersionBuilder setMasterAgreementVersionScheme(String masterAgreementVersionScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("masterAgreementVersionScheme"), String.class, getMasterAgreementVersionScheme(), this);
		}
		

		MasterAgreementVersion.MasterAgreementVersionBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementVersion  ***********************/
	class MasterAgreementVersionImpl implements MasterAgreementVersion {
		private final String value;
		private final String masterAgreementVersionScheme;
		
		protected MasterAgreementVersionImpl(MasterAgreementVersion.MasterAgreementVersionBuilder builder) {
			this.value = builder.getValue();
			this.masterAgreementVersionScheme = builder.getMasterAgreementVersionScheme();
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
		@RosettaAttribute("masterAgreementVersionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementVersionScheme")
		public String getMasterAgreementVersionScheme() {
			return masterAgreementVersionScheme;
		}
		
		@Override
		public MasterAgreementVersion build() {
			return this;
		}
		
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder toBuilder() {
			MasterAgreementVersion.MasterAgreementVersionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementVersion.MasterAgreementVersionBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMasterAgreementVersionScheme()).ifPresent(builder::setMasterAgreementVersionScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementVersionScheme, _that.getMasterAgreementVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersionScheme != null ? masterAgreementVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementVersion {" +
				"value=" + this.value + ", " +
				"masterAgreementVersionScheme=" + this.masterAgreementVersionScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementVersion  ***********************/
	class MasterAgreementVersionBuilderImpl implements MasterAgreementVersion.MasterAgreementVersionBuilder {
	
		protected String value;
		protected String masterAgreementVersionScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterAgreementVersionScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementVersionScheme")
		public String getMasterAgreementVersionScheme() {
			return masterAgreementVersionScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("masterAgreementVersionScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementVersionScheme")
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder setMasterAgreementVersionScheme(String _masterAgreementVersionScheme) {
			this.masterAgreementVersionScheme = _masterAgreementVersionScheme == null ? null : _masterAgreementVersionScheme;
			return this;
		}
		
		@Override
		public MasterAgreementVersion build() {
			return new MasterAgreementVersion.MasterAgreementVersionImpl(this);
		}
		
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMasterAgreementVersionScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementVersion.MasterAgreementVersionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementVersion.MasterAgreementVersionBuilder o = (MasterAgreementVersion.MasterAgreementVersionBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMasterAgreementVersionScheme(), o.getMasterAgreementVersionScheme(), this::setMasterAgreementVersionScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementVersion _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementVersionScheme, _that.getMasterAgreementVersionScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementVersionScheme != null ? masterAgreementVersionScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementVersionBuilder {" +
				"value=" + this.value + ", " +
				"masterAgreementVersionScheme=" + this.masterAgreementVersionScheme +
			'}';
		}
	}
}
