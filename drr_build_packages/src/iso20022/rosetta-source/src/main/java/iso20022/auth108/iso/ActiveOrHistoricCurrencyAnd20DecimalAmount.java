package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.ActiveOrHistoricCurrencyAnd20DecimalAmountMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
 * @version ${project.version}
 */
@RosettaDataType(value="ActiveOrHistoricCurrencyAnd20DecimalAmount", builder=ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilderImpl.class, version="${project.version}")
@RuneDataType(value="ActiveOrHistoricCurrencyAnd20DecimalAmount", model="iso20022", builder=ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilderImpl.class, version="${project.version}")
public interface ActiveOrHistoricCurrencyAnd20DecimalAmount extends RosettaModelObject {

	ActiveOrHistoricCurrencyAnd20DecimalAmountMeta metaData = new ActiveOrHistoricCurrencyAnd20DecimalAmountMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();
	String getCcy();

	/*********************** Build Methods  ***********************/
	ActiveOrHistoricCurrencyAnd20DecimalAmount build();
	
	ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder toBuilder();
	
	static ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder builder() {
		return new ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActiveOrHistoricCurrencyAnd20DecimalAmount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActiveOrHistoricCurrencyAnd20DecimalAmount> getType() {
		return ActiveOrHistoricCurrencyAnd20DecimalAmount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder extends ActiveOrHistoricCurrencyAnd20DecimalAmount, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder setValue(BigDecimal value);
		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder setCcy(String ccy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
		}
		

		ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder prune();
	}

	/*********************** Immutable Implementation of ActiveOrHistoricCurrencyAnd20DecimalAmount  ***********************/
	class ActiveOrHistoricCurrencyAnd20DecimalAmountImpl implements ActiveOrHistoricCurrencyAnd20DecimalAmount {
		private final BigDecimal value;
		private final String ccy;
		
		protected ActiveOrHistoricCurrencyAnd20DecimalAmountImpl(ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder builder) {
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
		public ActiveOrHistoricCurrencyAnd20DecimalAmount build() {
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder toBuilder() {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCcy()).ifPresent(builder::setCcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd20DecimalAmount _that = getType().cast(o);
		
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
			return "ActiveOrHistoricCurrencyAnd20DecimalAmount {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}

	/*********************** Builder Implementation of ActiveOrHistoricCurrencyAnd20DecimalAmount  ***********************/
	class ActiveOrHistoricCurrencyAnd20DecimalAmountBuilderImpl implements ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder {
	
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
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccy")
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder setCcy(String _ccy) {
			this.ccy = _ccy == null ? null : _ccy;
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount build() {
			return new ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountImpl(this);
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder prune() {
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
		public ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder o = (ActiveOrHistoricCurrencyAnd20DecimalAmount.ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCcy(), o.getCcy(), this::setCcy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd20DecimalAmount _that = getType().cast(o);
		
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
			return "ActiveOrHistoricCurrencyAnd20DecimalAmountBuilder {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}
}
