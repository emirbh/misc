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
import fpml.consolidated.loan.meta.FinancialMetricTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure used to uniquely identify a financial metric type, described by a scheme.
 *
 */
@RosettaDataType(value="FinancialMetricType", builder=FinancialMetricType.FinancialMetricTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FinancialMetricType", model="fpml", builder=FinancialMetricType.FinancialMetricTypeBuilderImpl.class, version="2.1.1")
public interface FinancialMetricType extends RosettaModelObject {

	FinancialMetricTypeMeta metaData = new FinancialMetricTypeMeta();

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
	String getFinancialMetricTypeScheme();

	/*********************** Build Methods  ***********************/
	FinancialMetricType build();
	
	FinancialMetricType.FinancialMetricTypeBuilder toBuilder();
	
	static FinancialMetricType.FinancialMetricTypeBuilder builder() {
		return new FinancialMetricType.FinancialMetricTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinancialMetricType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinancialMetricType> getType() {
		return FinancialMetricType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("financialMetricTypeScheme"), String.class, getFinancialMetricTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinancialMetricTypeBuilder extends FinancialMetricType, RosettaModelObjectBuilder {
		FinancialMetricType.FinancialMetricTypeBuilder setValue(String value);
		FinancialMetricType.FinancialMetricTypeBuilder setFinancialMetricTypeScheme(String financialMetricTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("financialMetricTypeScheme"), String.class, getFinancialMetricTypeScheme(), this);
		}
		

		FinancialMetricType.FinancialMetricTypeBuilder prune();
	}

	/*********************** Immutable Implementation of FinancialMetricType  ***********************/
	class FinancialMetricTypeImpl implements FinancialMetricType {
		private final String value;
		private final String financialMetricTypeScheme;
		
		protected FinancialMetricTypeImpl(FinancialMetricType.FinancialMetricTypeBuilder builder) {
			this.value = builder.getValue();
			this.financialMetricTypeScheme = builder.getFinancialMetricTypeScheme();
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
		@RosettaAttribute("financialMetricTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("financialMetricTypeScheme")
		public String getFinancialMetricTypeScheme() {
			return financialMetricTypeScheme;
		}
		
		@Override
		public FinancialMetricType build() {
			return this;
		}
		
		@Override
		public FinancialMetricType.FinancialMetricTypeBuilder toBuilder() {
			FinancialMetricType.FinancialMetricTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinancialMetricType.FinancialMetricTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getFinancialMetricTypeScheme()).ifPresent(builder::setFinancialMetricTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialMetricType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(financialMetricTypeScheme, _that.getFinancialMetricTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (financialMetricTypeScheme != null ? financialMetricTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialMetricType {" +
				"value=" + this.value + ", " +
				"financialMetricTypeScheme=" + this.financialMetricTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of FinancialMetricType  ***********************/
	class FinancialMetricTypeBuilderImpl implements FinancialMetricType.FinancialMetricTypeBuilder {
	
		protected String value;
		protected String financialMetricTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("financialMetricTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("financialMetricTypeScheme")
		public String getFinancialMetricTypeScheme() {
			return financialMetricTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public FinancialMetricType.FinancialMetricTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("financialMetricTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("financialMetricTypeScheme")
		@Override
		public FinancialMetricType.FinancialMetricTypeBuilder setFinancialMetricTypeScheme(String _financialMetricTypeScheme) {
			this.financialMetricTypeScheme = _financialMetricTypeScheme == null ? null : _financialMetricTypeScheme;
			return this;
		}
		
		@Override
		public FinancialMetricType build() {
			return new FinancialMetricType.FinancialMetricTypeImpl(this);
		}
		
		@Override
		public FinancialMetricType.FinancialMetricTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialMetricType.FinancialMetricTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getFinancialMetricTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinancialMetricType.FinancialMetricTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinancialMetricType.FinancialMetricTypeBuilder o = (FinancialMetricType.FinancialMetricTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getFinancialMetricTypeScheme(), o.getFinancialMetricTypeScheme(), this::setFinancialMetricTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinancialMetricType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(financialMetricTypeScheme, _that.getFinancialMetricTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (financialMetricTypeScheme != null ? financialMetricTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinancialMetricTypeBuilder {" +
				"value=" + this.value + ", " +
				"financialMetricTypeScheme=" + this.financialMetricTypeScheme +
			'}';
		}
	}
}
