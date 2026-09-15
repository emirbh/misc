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
import iso20022.auth030.esma.meta.ActiveOrHistoricCurrencyAnd20AmountMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
 * @version ${project.version}
 */
@RosettaDataType(value="ActiveOrHistoricCurrencyAnd20Amount", builder=ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilderImpl.class, version="${project.version}")
@RuneDataType(value="ActiveOrHistoricCurrencyAnd20Amount", model="iso20022", builder=ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilderImpl.class, version="${project.version}")
public interface ActiveOrHistoricCurrencyAnd20Amount extends RosettaModelObject {

	ActiveOrHistoricCurrencyAnd20AmountMeta metaData = new ActiveOrHistoricCurrencyAnd20AmountMeta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();
	/**
	 * Medium of exchange of currency.
	 */
	String getCcy();

	/*********************** Build Methods  ***********************/
	ActiveOrHistoricCurrencyAnd20Amount build();
	
	ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder toBuilder();
	
	static ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder builder() {
		return new ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActiveOrHistoricCurrencyAnd20Amount> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActiveOrHistoricCurrencyAnd20Amount> getType() {
		return ActiveOrHistoricCurrencyAnd20Amount.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActiveOrHistoricCurrencyAnd20AmountBuilder extends ActiveOrHistoricCurrencyAnd20Amount, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder setValue(BigDecimal value);
		ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder setCcy(String ccy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
		}
		

		ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder prune();
	}

	/*********************** Immutable Implementation of ActiveOrHistoricCurrencyAnd20Amount  ***********************/
	class ActiveOrHistoricCurrencyAnd20AmountImpl implements ActiveOrHistoricCurrencyAnd20Amount {
		private final BigDecimal value;
		private final String ccy;
		
		protected ActiveOrHistoricCurrencyAnd20AmountImpl(ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder builder) {
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
		public ActiveOrHistoricCurrencyAnd20Amount build() {
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder toBuilder() {
			ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCcy()).ifPresent(builder::setCcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd20Amount _that = getType().cast(o);
		
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
			return "ActiveOrHistoricCurrencyAnd20Amount {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}

	/*********************** Builder Implementation of ActiveOrHistoricCurrencyAnd20Amount  ***********************/
	class ActiveOrHistoricCurrencyAnd20AmountBuilderImpl implements ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder {
	
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
		public ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccy")
		@Override
		public ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder setCcy(String _ccy) {
			this.ccy = _ccy == null ? null : _ccy;
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20Amount build() {
			return new ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountImpl(this);
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder prune() {
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
		public ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder o = (ActiveOrHistoricCurrencyAnd20Amount.ActiveOrHistoricCurrencyAnd20AmountBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCcy(), o.getCcy(), this::setCcy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd20Amount _that = getType().cast(o);
		
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
			return "ActiveOrHistoricCurrencyAnd20AmountBuilder {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}
}
