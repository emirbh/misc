package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.CashflowIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision An identifier used to identify a single component cashflow.
 *
 */
@RosettaDataType(value="CashflowId", builder=CashflowId.CashflowIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CashflowId", model="fpml", builder=CashflowId.CashflowIdBuilderImpl.class, version="2.1.1")
public interface CashflowId extends RosettaModelObject {

	CashflowIdMeta metaData = new CashflowIdMeta();

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
	String getCashflowIdScheme();

	/*********************** Build Methods  ***********************/
	CashflowId build();
	
	CashflowId.CashflowIdBuilder toBuilder();
	
	static CashflowId.CashflowIdBuilder builder() {
		return new CashflowId.CashflowIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CashflowId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CashflowId> getType() {
		return CashflowId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("cashflowIdScheme"), String.class, getCashflowIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CashflowIdBuilder extends CashflowId, RosettaModelObjectBuilder {
		CashflowId.CashflowIdBuilder setValue(String value);
		CashflowId.CashflowIdBuilder setCashflowIdScheme(String cashflowIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("cashflowIdScheme"), String.class, getCashflowIdScheme(), this);
		}
		

		CashflowId.CashflowIdBuilder prune();
	}

	/*********************** Immutable Implementation of CashflowId  ***********************/
	class CashflowIdImpl implements CashflowId {
		private final String value;
		private final String cashflowIdScheme;
		
		protected CashflowIdImpl(CashflowId.CashflowIdBuilder builder) {
			this.value = builder.getValue();
			this.cashflowIdScheme = builder.getCashflowIdScheme();
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
		@RosettaAttribute("cashflowIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowIdScheme")
		public String getCashflowIdScheme() {
			return cashflowIdScheme;
		}
		
		@Override
		public CashflowId build() {
			return this;
		}
		
		@Override
		public CashflowId.CashflowIdBuilder toBuilder() {
			CashflowId.CashflowIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashflowId.CashflowIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getCashflowIdScheme()).ifPresent(builder::setCashflowIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cashflowIdScheme, _that.getCashflowIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cashflowIdScheme != null ? cashflowIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowId {" +
				"value=" + this.value + ", " +
				"cashflowIdScheme=" + this.cashflowIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of CashflowId  ***********************/
	class CashflowIdBuilderImpl implements CashflowId.CashflowIdBuilder {
	
		protected String value;
		protected String cashflowIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("cashflowIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cashflowIdScheme")
		public String getCashflowIdScheme() {
			return cashflowIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public CashflowId.CashflowIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("cashflowIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashflowIdScheme")
		@Override
		public CashflowId.CashflowIdBuilder setCashflowIdScheme(String _cashflowIdScheme) {
			this.cashflowIdScheme = _cashflowIdScheme == null ? null : _cashflowIdScheme;
			return this;
		}
		
		@Override
		public CashflowId build() {
			return new CashflowId.CashflowIdImpl(this);
		}
		
		@Override
		public CashflowId.CashflowIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowId.CashflowIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getCashflowIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashflowId.CashflowIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CashflowId.CashflowIdBuilder o = (CashflowId.CashflowIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getCashflowIdScheme(), o.getCashflowIdScheme(), this::setCashflowIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CashflowId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(cashflowIdScheme, _that.getCashflowIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (cashflowIdScheme != null ? cashflowIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashflowIdBuilder {" +
				"value=" + this.value + ", " +
				"cashflowIdScheme=" + this.cashflowIdScheme +
			'}';
		}
	}
}
