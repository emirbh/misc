package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.ActiveOrHistoricCurrencyAnd19DecimalAmountMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
 * @version ${project.version}
 */
@RosettaDataType(value="ActiveOrHistoricCurrencyAnd19DecimalAmount", builder=ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilderImpl.class, version="${project.version}")
@RuneDataType(value="ActiveOrHistoricCurrencyAnd19DecimalAmount", model="iso20022", builder=ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilderImpl.class, version="${project.version}")
public interface ActiveOrHistoricCurrencyAnd19DecimalAmount extends RosettaModelObject {

	ActiveOrHistoricCurrencyAnd19DecimalAmountMeta metaData = new ActiveOrHistoricCurrencyAnd19DecimalAmountMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();
	/**
	 * Medium of exchange of value.
	 */
	String getCcy();

	/*********************** Build Methods  ***********************/
	ActiveOrHistoricCurrencyAnd19DecimalAmount build();
	
	ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder toBuilder();
	
	static ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder builder() {
		return new ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActiveOrHistoricCurrencyAnd19DecimalAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActiveOrHistoricCurrencyAnd19DecimalAmount> getType() {
		return ActiveOrHistoricCurrencyAnd19DecimalAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder extends ActiveOrHistoricCurrencyAnd19DecimalAmount, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder setValue(BigDecimal value);
		ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder setCcy(String ccy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
		}
		

		ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder prune();
	}

	/*********************** Immutable Implementation of ActiveOrHistoricCurrencyAnd19DecimalAmount  ***********************/
	class ActiveOrHistoricCurrencyAnd19DecimalAmountImpl implements ActiveOrHistoricCurrencyAnd19DecimalAmount {
		private final BigDecimal value;
		private final String ccy;
		
		protected ActiveOrHistoricCurrencyAnd19DecimalAmountImpl(ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder builder) {
			this.value = builder.getValue();
			this.ccy = builder.getCcy();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccy")
		public String getCcy() {
			return ccy;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount build() {
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder toBuilder() {
			ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCcy()).ifPresent(builder::setCcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd19DecimalAmount _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActiveOrHistoricCurrencyAnd19DecimalAmount {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}

	/*********************** Builder Implementation of ActiveOrHistoricCurrencyAnd19DecimalAmount  ***********************/
	class ActiveOrHistoricCurrencyAnd19DecimalAmountBuilderImpl implements ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder {
	
		protected BigDecimal value;
		protected String ccy;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public BigDecimal getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccy")
		public String getCcy() {
			return ccy;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccy")
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder setCcy(String _ccy) {
			this.ccy = _ccy == null ? null : _ccy;
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount build() {
			return new ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountImpl(this);
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCcy()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder o = (ActiveOrHistoricCurrencyAnd19DecimalAmount.ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCcy(), o.getCcy(), this::setCcy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd19DecimalAmount _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActiveOrHistoricCurrencyAnd19DecimalAmountBuilder {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}
}
