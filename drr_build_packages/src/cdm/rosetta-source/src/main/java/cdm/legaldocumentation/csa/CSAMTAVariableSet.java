package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CSAMTAVariableSetMeta;
import cdm.observable.asset.CreditRatingAgencyEnum;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a combination of Rating Agency, Rating Value, amount and Currency code.
 * @version 6.23.0
 */
@RosettaDataType(value="CSAMTAVariableSet", builder=CSAMTAVariableSet.CSAMTAVariableSetBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CSAMTAVariableSet", model="cdm", builder=CSAMTAVariableSet.CSAMTAVariableSetBuilderImpl.class, version="6.23.0")
public interface CSAMTAVariableSet extends RosettaModelObject {

	CSAMTAVariableSetMeta metaData = new CSAMTAVariableSetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the Rating Agency.
	 */
	CreditRatingAgencyEnum getName();
	/**
	 * The value assigned to the rating.
	 */
	String getValue();
	/**
	 * The Minimum Transfer Amount (MTA) applicable to the Rating.
	 */
	Integer getAmount();
	/**
	 * A flag that defines the Minimum Transfer Amount (MTA) as Infinity.
	 */
	Boolean getAmountIsInfinity();

	/*********************** Build Methods  ***********************/
	CSAMTAVariableSet build();
	
	CSAMTAVariableSet.CSAMTAVariableSetBuilder toBuilder();
	
	static CSAMTAVariableSet.CSAMTAVariableSetBuilder builder() {
		return new CSAMTAVariableSet.CSAMTAVariableSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSAMTAVariableSet> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSAMTAVariableSet> getType() {
		return CSAMTAVariableSet.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), CreditRatingAgencyEnum.class, getName(), this);
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
		processor.processBasic(path.newSubPath("amountIsInfinity"), Boolean.class, getAmountIsInfinity(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSAMTAVariableSetBuilder extends CSAMTAVariableSet, RosettaModelObjectBuilder {
		CSAMTAVariableSet.CSAMTAVariableSetBuilder setName(CreditRatingAgencyEnum name);
		CSAMTAVariableSet.CSAMTAVariableSetBuilder setValue(String value);
		CSAMTAVariableSet.CSAMTAVariableSetBuilder setAmount(Integer amount);
		CSAMTAVariableSet.CSAMTAVariableSetBuilder setAmountIsInfinity(Boolean amountIsInfinity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), CreditRatingAgencyEnum.class, getName(), this);
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
			processor.processBasic(path.newSubPath("amountIsInfinity"), Boolean.class, getAmountIsInfinity(), this);
		}
		

		CSAMTAVariableSet.CSAMTAVariableSetBuilder prune();
	}

	/*********************** Immutable Implementation of CSAMTAVariableSet  ***********************/
	class CSAMTAVariableSetImpl implements CSAMTAVariableSet {
		private final CreditRatingAgencyEnum name;
		private final String value;
		private final Integer amount;
		private final Boolean amountIsInfinity;
		
		protected CSAMTAVariableSetImpl(CSAMTAVariableSet.CSAMTAVariableSetBuilder builder) {
			this.name = builder.getName();
			this.value = builder.getValue();
			this.amount = builder.getAmount();
			this.amountIsInfinity = builder.getAmountIsInfinity();
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public CreditRatingAgencyEnum getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Integer getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("amountIsInfinity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountIsInfinity")
		public Boolean getAmountIsInfinity() {
			return amountIsInfinity;
		}
		
		@Override
		public CSAMTAVariableSet build() {
			return this;
		}
		
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder toBuilder() {
			CSAMTAVariableSet.CSAMTAVariableSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSAMTAVariableSet.CSAMTAVariableSetBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAmountIsInfinity()).ifPresent(builder::setAmountIsInfinity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAMTAVariableSet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(amountIsInfinity, _that.getAmountIsInfinity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (amountIsInfinity != null ? amountIsInfinity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAMTAVariableSet {" +
				"name=" + this.name + ", " +
				"value=" + this.value + ", " +
				"amount=" + this.amount + ", " +
				"amountIsInfinity=" + this.amountIsInfinity +
			'}';
		}
	}

	/*********************** Builder Implementation of CSAMTAVariableSet  ***********************/
	class CSAMTAVariableSetBuilderImpl implements CSAMTAVariableSet.CSAMTAVariableSetBuilder {
	
		protected CreditRatingAgencyEnum name;
		protected String value;
		protected Integer amount;
		protected Boolean amountIsInfinity;
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public CreditRatingAgencyEnum getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amount")
		public Integer getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("amountIsInfinity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("amountIsInfinity")
		public Boolean getAmountIsInfinity() {
			return amountIsInfinity;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder setName(CreditRatingAgencyEnum _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("value")
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder setAmount(Integer _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@RosettaAttribute("amountIsInfinity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amountIsInfinity")
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder setAmountIsInfinity(Boolean _amountIsInfinity) {
			this.amountIsInfinity = _amountIsInfinity == null ? null : _amountIsInfinity;
			return this;
		}
		
		@Override
		public CSAMTAVariableSet build() {
			return new CSAMTAVariableSet.CSAMTAVariableSetImpl(this);
		}
		
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getValue()!=null) return true;
			if (getAmount()!=null) return true;
			if (getAmountIsInfinity()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CSAMTAVariableSet.CSAMTAVariableSetBuilder o = (CSAMTAVariableSet.CSAMTAVariableSetBuilder) other;
			
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getAmountIsInfinity(), o.getAmountIsInfinity(), this::setAmountIsInfinity);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAMTAVariableSet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(amountIsInfinity, _that.getAmountIsInfinity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (amountIsInfinity != null ? amountIsInfinity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAMTAVariableSetBuilder {" +
				"name=" + this.name + ", " +
				"value=" + this.value + ", " +
				"amount=" + this.amount + ", " +
				"amountIsInfinity=" + this.amountIsInfinity +
			'}';
		}
	}
}
