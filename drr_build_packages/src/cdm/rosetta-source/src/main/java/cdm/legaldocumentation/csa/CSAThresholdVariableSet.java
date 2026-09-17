package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.CSAThresholdVariableSetMeta;
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
 * Defines a combination of Rating Agency, Rating Value, Threshold amount and Currency code.
 * @version 6.23.0
 */
@RosettaDataType(value="CSAThresholdVariableSet", builder=CSAThresholdVariableSet.CSAThresholdVariableSetBuilderImpl.class, version="6.23.0")
@RuneDataType(value="CSAThresholdVariableSet", model="cdm", builder=CSAThresholdVariableSet.CSAThresholdVariableSetBuilderImpl.class, version="6.23.0")
public interface CSAThresholdVariableSet extends RosettaModelObject {

	CSAThresholdVariableSetMeta metaData = new CSAThresholdVariableSetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The relevant rating agency.
	 */
	CreditRatingAgencyEnum getName();
	/**
	 * Rating applicable to the party from a given rating agency.
	 */
	String getValue();
	/**
	 * The amount value applicable to the Threshold.
	 */
	Integer getAmount();

	/*********************** Build Methods  ***********************/
	CSAThresholdVariableSet build();
	
	CSAThresholdVariableSet.CSAThresholdVariableSetBuilder toBuilder();
	
	static CSAThresholdVariableSet.CSAThresholdVariableSetBuilder builder() {
		return new CSAThresholdVariableSet.CSAThresholdVariableSetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CSAThresholdVariableSet> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CSAThresholdVariableSet> getType() {
		return CSAThresholdVariableSet.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), CreditRatingAgencyEnum.class, getName(), this);
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CSAThresholdVariableSetBuilder extends CSAThresholdVariableSet, RosettaModelObjectBuilder {
		CSAThresholdVariableSet.CSAThresholdVariableSetBuilder setName(CreditRatingAgencyEnum name);
		CSAThresholdVariableSet.CSAThresholdVariableSetBuilder setValue(String value);
		CSAThresholdVariableSet.CSAThresholdVariableSetBuilder setAmount(Integer amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), CreditRatingAgencyEnum.class, getName(), this);
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("amount"), Integer.class, getAmount(), this);
		}
		

		CSAThresholdVariableSet.CSAThresholdVariableSetBuilder prune();
	}

	/*********************** Immutable Implementation of CSAThresholdVariableSet  ***********************/
	class CSAThresholdVariableSetImpl implements CSAThresholdVariableSet {
		private final CreditRatingAgencyEnum name;
		private final String value;
		private final Integer amount;
		
		protected CSAThresholdVariableSetImpl(CSAThresholdVariableSet.CSAThresholdVariableSetBuilder builder) {
			this.name = builder.getName();
			this.value = builder.getValue();
			this.amount = builder.getAmount();
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
		public CSAThresholdVariableSet build() {
			return this;
		}
		
		@Override
		public CSAThresholdVariableSet.CSAThresholdVariableSetBuilder toBuilder() {
			CSAThresholdVariableSet.CSAThresholdVariableSetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CSAThresholdVariableSet.CSAThresholdVariableSetBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAThresholdVariableSet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAThresholdVariableSet {" +
				"name=" + this.name + ", " +
				"value=" + this.value + ", " +
				"amount=" + this.amount +
			'}';
		}
	}

	/*********************** Builder Implementation of CSAThresholdVariableSet  ***********************/
	class CSAThresholdVariableSetBuilderImpl implements CSAThresholdVariableSet.CSAThresholdVariableSetBuilder {
	
		protected CreditRatingAgencyEnum name;
		protected String value;
		protected Integer amount;
		
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
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public CSAThresholdVariableSet.CSAThresholdVariableSetBuilder setName(CreditRatingAgencyEnum _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("value")
		@Override
		public CSAThresholdVariableSet.CSAThresholdVariableSetBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("amount")
		@Override
		public CSAThresholdVariableSet.CSAThresholdVariableSetBuilder setAmount(Integer _amount) {
			this.amount = _amount == null ? null : _amount;
			return this;
		}
		
		@Override
		public CSAThresholdVariableSet build() {
			return new CSAThresholdVariableSet.CSAThresholdVariableSetImpl(this);
		}
		
		@Override
		public CSAThresholdVariableSet.CSAThresholdVariableSetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAThresholdVariableSet.CSAThresholdVariableSetBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getValue()!=null) return true;
			if (getAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CSAThresholdVariableSet.CSAThresholdVariableSetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CSAThresholdVariableSet.CSAThresholdVariableSetBuilder o = (CSAThresholdVariableSet.CSAThresholdVariableSetBuilder) other;
			
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CSAThresholdVariableSet _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CSAThresholdVariableSetBuilder {" +
				"name=" + this.name + ", " +
				"value=" + this.value + ", " +
				"amount=" + this.amount +
			'}';
		}
	}
}
