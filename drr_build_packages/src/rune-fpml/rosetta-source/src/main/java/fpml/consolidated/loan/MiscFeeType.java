package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.MiscFeeTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A list of all miscellaneous (one-off) fee types.
 *
 */
@RosettaDataType(value="MiscFeeType", builder=MiscFeeType.MiscFeeTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MiscFeeType", model="fpml", builder=MiscFeeType.MiscFeeTypeBuilderImpl.class, version="2.1.1")
public interface MiscFeeType extends RosettaModelObject {

	MiscFeeTypeMeta metaData = new MiscFeeTypeMeta();

	/*********************** Getter Methods  ***********************/
	/**
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
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getMiscFeeTypeScheme();

	/*********************** Build Methods  ***********************/
	MiscFeeType build();
	
	MiscFeeType.MiscFeeTypeBuilder toBuilder();
	
	static MiscFeeType.MiscFeeTypeBuilder builder() {
		return new MiscFeeType.MiscFeeTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MiscFeeType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MiscFeeType> getType() {
		return MiscFeeType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("miscFeeTypeScheme"), String.class, getMiscFeeTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MiscFeeTypeBuilder extends MiscFeeType, RosettaModelObjectBuilder {
		MiscFeeType.MiscFeeTypeBuilder setValue(String value);
		MiscFeeType.MiscFeeTypeBuilder setMiscFeeTypeScheme(String miscFeeTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("miscFeeTypeScheme"), String.class, getMiscFeeTypeScheme(), this);
		}
		

		MiscFeeType.MiscFeeTypeBuilder prune();
	}

	/*********************** Immutable Implementation of MiscFeeType  ***********************/
	class MiscFeeTypeImpl implements MiscFeeType {
		private final String value;
		private final String miscFeeTypeScheme;
		
		protected MiscFeeTypeImpl(MiscFeeType.MiscFeeTypeBuilder builder) {
			this.value = builder.getValue();
			this.miscFeeTypeScheme = builder.getMiscFeeTypeScheme();
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
		@RosettaAttribute("miscFeeTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("miscFeeTypeScheme")
		public String getMiscFeeTypeScheme() {
			return miscFeeTypeScheme;
		}
		
		@Override
		public MiscFeeType build() {
			return this;
		}
		
		@Override
		public MiscFeeType.MiscFeeTypeBuilder toBuilder() {
			MiscFeeType.MiscFeeTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MiscFeeType.MiscFeeTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMiscFeeTypeScheme()).ifPresent(builder::setMiscFeeTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MiscFeeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(miscFeeTypeScheme, _that.getMiscFeeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (miscFeeTypeScheme != null ? miscFeeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MiscFeeType {" +
				"value=" + this.value + ", " +
				"miscFeeTypeScheme=" + this.miscFeeTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MiscFeeType  ***********************/
	class MiscFeeTypeBuilderImpl implements MiscFeeType.MiscFeeTypeBuilder {
	
		protected String value;
		protected String miscFeeTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("miscFeeTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("miscFeeTypeScheme")
		public String getMiscFeeTypeScheme() {
			return miscFeeTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MiscFeeType.MiscFeeTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("miscFeeTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("miscFeeTypeScheme")
		@Override
		public MiscFeeType.MiscFeeTypeBuilder setMiscFeeTypeScheme(String _miscFeeTypeScheme) {
			this.miscFeeTypeScheme = _miscFeeTypeScheme == null ? null : _miscFeeTypeScheme;
			return this;
		}
		
		@Override
		public MiscFeeType build() {
			return new MiscFeeType.MiscFeeTypeImpl(this);
		}
		
		@Override
		public MiscFeeType.MiscFeeTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MiscFeeType.MiscFeeTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMiscFeeTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MiscFeeType.MiscFeeTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MiscFeeType.MiscFeeTypeBuilder o = (MiscFeeType.MiscFeeTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMiscFeeTypeScheme(), o.getMiscFeeTypeScheme(), this::setMiscFeeTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MiscFeeType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(miscFeeTypeScheme, _that.getMiscFeeTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (miscFeeTypeScheme != null ? miscFeeTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MiscFeeTypeBuilder {" +
				"value=" + this.value + ", " +
				"miscFeeTypeScheme=" + this.miscFeeTypeScheme +
			'}';
		}
	}
}
