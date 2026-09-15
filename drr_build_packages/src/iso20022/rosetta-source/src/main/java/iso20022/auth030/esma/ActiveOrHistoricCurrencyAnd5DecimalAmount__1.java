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
import iso20022.auth030.esma.meta.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
 * @version ${project.version}
 */
@RosettaDataType(value="ActiveOrHistoricCurrencyAnd5DecimalAmount__1", builder=ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ActiveOrHistoricCurrencyAnd5DecimalAmount__1", model="iso20022", builder=ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1BuilderImpl.class, version="${project.version}")
public interface ActiveOrHistoricCurrencyAnd5DecimalAmount__1 extends RosettaModelObject {

	ActiveOrHistoricCurrencyAnd5DecimalAmount__1Meta metaData = new ActiveOrHistoricCurrencyAnd5DecimalAmount__1Meta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getValue();
	/**
	 * Medium of exchange of value.
	 */
	String getCcy();

	/*********************** Build Methods  ***********************/
	ActiveOrHistoricCurrencyAnd5DecimalAmount__1 build();
	
	ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder toBuilder();
	
	static ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder builder() {
		return new ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActiveOrHistoricCurrencyAnd5DecimalAmount__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActiveOrHistoricCurrencyAnd5DecimalAmount__1> getType() {
		return ActiveOrHistoricCurrencyAnd5DecimalAmount__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
		processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder extends ActiveOrHistoricCurrencyAnd5DecimalAmount__1, RosettaModelObjectBuilder {
		ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder setValue(BigDecimal value);
		ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder setCcy(String ccy);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), BigDecimal.class, getValue(), this);
			processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
		}
		

		ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder prune();
	}

	/*********************** Immutable Implementation of ActiveOrHistoricCurrencyAnd5DecimalAmount__1  ***********************/
	class ActiveOrHistoricCurrencyAnd5DecimalAmount__1Impl implements ActiveOrHistoricCurrencyAnd5DecimalAmount__1 {
		private final BigDecimal value;
		private final String ccy;
		
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount__1Impl(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder builder) {
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
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1 build() {
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder toBuilder() {
			ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCcy()).ifPresent(builder::setCcy);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd5DecimalAmount__1 _that = getType().cast(o);
		
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
			return "ActiveOrHistoricCurrencyAnd5DecimalAmount__1 {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}

	/*********************** Builder Implementation of ActiveOrHistoricCurrencyAnd5DecimalAmount__1  ***********************/
	class ActiveOrHistoricCurrencyAnd5DecimalAmount__1BuilderImpl implements ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder {
	
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
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder setValue(BigDecimal _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccy")
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder setCcy(String _ccy) {
			this.ccy = _ccy == null ? null : _ccy;
			return this;
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1 build() {
			return new ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Impl(this);
		}
		
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder prune() {
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
		public ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder o = (ActiveOrHistoricCurrencyAnd5DecimalAmount__1.ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCcy(), o.getCcy(), this::setCcy);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActiveOrHistoricCurrencyAnd5DecimalAmount__1 _that = getType().cast(o);
		
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
			return "ActiveOrHistoricCurrencyAnd5DecimalAmount__1Builder {" +
				"value=" + this.value + ", " +
				"ccy=" + this.ccy +
			'}';
		}
	}
}
