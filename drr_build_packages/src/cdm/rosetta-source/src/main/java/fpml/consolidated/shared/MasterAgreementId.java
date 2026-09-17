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
import fpml.consolidated.shared.meta.MasterAgreementIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A master agreement identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A master agreement identifier allocated by a party. FpML does not define the domain values associated with this element. Note that the domain values for this element are not strictly an enumerated list.
 *
 */
@RosettaDataType(value="MasterAgreementId", builder=MasterAgreementId.MasterAgreementIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MasterAgreementId", model="fpml", builder=MasterAgreementId.MasterAgreementIdBuilderImpl.class, version="2.1.1")
public interface MasterAgreementId extends RosettaModelObject {

	MasterAgreementIdMeta metaData = new MasterAgreementIdMeta();

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
	String getMasterAgreementIdScheme();

	/*********************** Build Methods  ***********************/
	MasterAgreementId build();
	
	MasterAgreementId.MasterAgreementIdBuilder toBuilder();
	
	static MasterAgreementId.MasterAgreementIdBuilder builder() {
		return new MasterAgreementId.MasterAgreementIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreementId> getType() {
		return MasterAgreementId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("masterAgreementIdScheme"), String.class, getMasterAgreementIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementIdBuilder extends MasterAgreementId, RosettaModelObjectBuilder {
		MasterAgreementId.MasterAgreementIdBuilder setValue(String value);
		MasterAgreementId.MasterAgreementIdBuilder setMasterAgreementIdScheme(String masterAgreementIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("masterAgreementIdScheme"), String.class, getMasterAgreementIdScheme(), this);
		}
		

		MasterAgreementId.MasterAgreementIdBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementId  ***********************/
	class MasterAgreementIdImpl implements MasterAgreementId {
		private final String value;
		private final String masterAgreementIdScheme;
		
		protected MasterAgreementIdImpl(MasterAgreementId.MasterAgreementIdBuilder builder) {
			this.value = builder.getValue();
			this.masterAgreementIdScheme = builder.getMasterAgreementIdScheme();
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
		@RosettaAttribute("masterAgreementIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementIdScheme")
		public String getMasterAgreementIdScheme() {
			return masterAgreementIdScheme;
		}
		
		@Override
		public MasterAgreementId build() {
			return this;
		}
		
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder toBuilder() {
			MasterAgreementId.MasterAgreementIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementId.MasterAgreementIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMasterAgreementIdScheme()).ifPresent(builder::setMasterAgreementIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementIdScheme, _that.getMasterAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementIdScheme != null ? masterAgreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementId {" +
				"value=" + this.value + ", " +
				"masterAgreementIdScheme=" + this.masterAgreementIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementId  ***********************/
	class MasterAgreementIdBuilderImpl implements MasterAgreementId.MasterAgreementIdBuilder {
	
		protected String value;
		protected String masterAgreementIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("masterAgreementIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementIdScheme")
		public String getMasterAgreementIdScheme() {
			return masterAgreementIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("masterAgreementIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementIdScheme")
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder setMasterAgreementIdScheme(String _masterAgreementIdScheme) {
			this.masterAgreementIdScheme = _masterAgreementIdScheme == null ? null : _masterAgreementIdScheme;
			return this;
		}
		
		@Override
		public MasterAgreementId build() {
			return new MasterAgreementId.MasterAgreementIdImpl(this);
		}
		
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMasterAgreementIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementId.MasterAgreementIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementId.MasterAgreementIdBuilder o = (MasterAgreementId.MasterAgreementIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMasterAgreementIdScheme(), o.getMasterAgreementIdScheme(), this::setMasterAgreementIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(masterAgreementIdScheme, _that.getMasterAgreementIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (masterAgreementIdScheme != null ? masterAgreementIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementIdBuilder {" +
				"value=" + this.value + ", " +
				"masterAgreementIdScheme=" + this.masterAgreementIdScheme +
			'}';
		}
	}
}
