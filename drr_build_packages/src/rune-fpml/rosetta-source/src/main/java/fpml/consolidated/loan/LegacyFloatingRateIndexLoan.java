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
import fpml.consolidated.loan.meta.LegacyFloatingRateIndexLoanMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A legacy subset of the ISDA Floating Rate Option scheme, i.e. the floating rate index. These are the pre-IBOR replacement indices used by the syndicated loan market.
 *
 */
@RosettaDataType(value="LegacyFloatingRateIndexLoan", builder=LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LegacyFloatingRateIndexLoan", model="fpml", builder=LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilderImpl.class, version="2.1.1")
public interface LegacyFloatingRateIndexLoan extends RosettaModelObject {

	LegacyFloatingRateIndexLoanMeta metaData = new LegacyFloatingRateIndexLoanMeta();

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
	String getLegacyFloatingRateIndexScheme();

	/*********************** Build Methods  ***********************/
	LegacyFloatingRateIndexLoan build();
	
	LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder toBuilder();
	
	static LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder builder() {
		return new LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LegacyFloatingRateIndexLoan> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LegacyFloatingRateIndexLoan> getType() {
		return LegacyFloatingRateIndexLoan.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("legacyFloatingRateIndexScheme"), String.class, getLegacyFloatingRateIndexScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LegacyFloatingRateIndexLoanBuilder extends LegacyFloatingRateIndexLoan, RosettaModelObjectBuilder {
		LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder setValue(String value);
		LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder setLegacyFloatingRateIndexScheme(String legacyFloatingRateIndexScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("legacyFloatingRateIndexScheme"), String.class, getLegacyFloatingRateIndexScheme(), this);
		}
		

		LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder prune();
	}

	/*********************** Immutable Implementation of LegacyFloatingRateIndexLoan  ***********************/
	class LegacyFloatingRateIndexLoanImpl implements LegacyFloatingRateIndexLoan {
		private final String value;
		private final String legacyFloatingRateIndexScheme;
		
		protected LegacyFloatingRateIndexLoanImpl(LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder builder) {
			this.value = builder.getValue();
			this.legacyFloatingRateIndexScheme = builder.getLegacyFloatingRateIndexScheme();
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
		@RosettaAttribute("legacyFloatingRateIndexScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateIndexScheme")
		public String getLegacyFloatingRateIndexScheme() {
			return legacyFloatingRateIndexScheme;
		}
		
		@Override
		public LegacyFloatingRateIndexLoan build() {
			return this;
		}
		
		@Override
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder toBuilder() {
			LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLegacyFloatingRateIndexScheme()).ifPresent(builder::setLegacyFloatingRateIndexScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyFloatingRateIndexLoan _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legacyFloatingRateIndexScheme, _that.getLegacyFloatingRateIndexScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateIndexScheme != null ? legacyFloatingRateIndexScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyFloatingRateIndexLoan {" +
				"value=" + this.value + ", " +
				"legacyFloatingRateIndexScheme=" + this.legacyFloatingRateIndexScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LegacyFloatingRateIndexLoan  ***********************/
	class LegacyFloatingRateIndexLoanBuilderImpl implements LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder {
	
		protected String value;
		protected String legacyFloatingRateIndexScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("legacyFloatingRateIndexScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("legacyFloatingRateIndexScheme")
		public String getLegacyFloatingRateIndexScheme() {
			return legacyFloatingRateIndexScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("legacyFloatingRateIndexScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("legacyFloatingRateIndexScheme")
		@Override
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder setLegacyFloatingRateIndexScheme(String _legacyFloatingRateIndexScheme) {
			this.legacyFloatingRateIndexScheme = _legacyFloatingRateIndexScheme == null ? null : _legacyFloatingRateIndexScheme;
			return this;
		}
		
		@Override
		public LegacyFloatingRateIndexLoan build() {
			return new LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanImpl(this);
		}
		
		@Override
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLegacyFloatingRateIndexScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder o = (LegacyFloatingRateIndexLoan.LegacyFloatingRateIndexLoanBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLegacyFloatingRateIndexScheme(), o.getLegacyFloatingRateIndexScheme(), this::setLegacyFloatingRateIndexScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegacyFloatingRateIndexLoan _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(legacyFloatingRateIndexScheme, _that.getLegacyFloatingRateIndexScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (legacyFloatingRateIndexScheme != null ? legacyFloatingRateIndexScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegacyFloatingRateIndexLoanBuilder {" +
				"value=" + this.value + ", " +
				"legacyFloatingRateIndexScheme=" + this.legacyFloatingRateIndexScheme +
			'}';
		}
	}
}
