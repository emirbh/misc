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
import fpml.consolidated.loan.meta.LoanAllocationNoSettlePeriodTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure that defines no-settle period types based on a qualifying scheme.
 *
 */
@RosettaDataType(value="LoanAllocationNoSettlePeriodType", builder=LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationNoSettlePeriodType", model="fpml", builder=LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilderImpl.class, version="2.1.1")
public interface LoanAllocationNoSettlePeriodType extends RosettaModelObject {

	LoanAllocationNoSettlePeriodTypeMeta metaData = new LoanAllocationNoSettlePeriodTypeMeta();

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
	String getNoSettlePeriodTypeScheme();

	/*********************** Build Methods  ***********************/
	LoanAllocationNoSettlePeriodType build();
	
	LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder toBuilder();
	
	static LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder builder() {
		return new LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationNoSettlePeriodType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationNoSettlePeriodType> getType() {
		return LoanAllocationNoSettlePeriodType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("noSettlePeriodTypeScheme"), String.class, getNoSettlePeriodTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationNoSettlePeriodTypeBuilder extends LoanAllocationNoSettlePeriodType, RosettaModelObjectBuilder {
		LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder setValue(String value);
		LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder setNoSettlePeriodTypeScheme(String noSettlePeriodTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("noSettlePeriodTypeScheme"), String.class, getNoSettlePeriodTypeScheme(), this);
		}
		

		LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationNoSettlePeriodType  ***********************/
	class LoanAllocationNoSettlePeriodTypeImpl implements LoanAllocationNoSettlePeriodType {
		private final String value;
		private final String noSettlePeriodTypeScheme;
		
		protected LoanAllocationNoSettlePeriodTypeImpl(LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder builder) {
			this.value = builder.getValue();
			this.noSettlePeriodTypeScheme = builder.getNoSettlePeriodTypeScheme();
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
		@RosettaAttribute("noSettlePeriodTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noSettlePeriodTypeScheme")
		public String getNoSettlePeriodTypeScheme() {
			return noSettlePeriodTypeScheme;
		}
		
		@Override
		public LoanAllocationNoSettlePeriodType build() {
			return this;
		}
		
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder toBuilder() {
			LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getNoSettlePeriodTypeScheme()).ifPresent(builder::setNoSettlePeriodTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNoSettlePeriodType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(noSettlePeriodTypeScheme, _that.getNoSettlePeriodTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (noSettlePeriodTypeScheme != null ? noSettlePeriodTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNoSettlePeriodType {" +
				"value=" + this.value + ", " +
				"noSettlePeriodTypeScheme=" + this.noSettlePeriodTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationNoSettlePeriodType  ***********************/
	class LoanAllocationNoSettlePeriodTypeBuilderImpl implements LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder {
	
		protected String value;
		protected String noSettlePeriodTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("noSettlePeriodTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("noSettlePeriodTypeScheme")
		public String getNoSettlePeriodTypeScheme() {
			return noSettlePeriodTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("noSettlePeriodTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("noSettlePeriodTypeScheme")
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder setNoSettlePeriodTypeScheme(String _noSettlePeriodTypeScheme) {
			this.noSettlePeriodTypeScheme = _noSettlePeriodTypeScheme == null ? null : _noSettlePeriodTypeScheme;
			return this;
		}
		
		@Override
		public LoanAllocationNoSettlePeriodType build() {
			return new LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeImpl(this);
		}
		
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getNoSettlePeriodTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder o = (LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getNoSettlePeriodTypeScheme(), o.getNoSettlePeriodTypeScheme(), this::setNoSettlePeriodTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNoSettlePeriodType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(noSettlePeriodTypeScheme, _that.getNoSettlePeriodTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (noSettlePeriodTypeScheme != null ? noSettlePeriodTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNoSettlePeriodTypeBuilder {" +
				"value=" + this.value + ", " +
				"noSettlePeriodTypeScheme=" + this.noSettlePeriodTypeScheme +
			'}';
		}
	}
}
