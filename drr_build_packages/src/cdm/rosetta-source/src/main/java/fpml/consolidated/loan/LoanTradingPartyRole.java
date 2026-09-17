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
import fpml.consolidated.loan.meta.LoanTradingPartyRoleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type that describes a role played by a party in a trading transaction. Examples include roles such as guarantor, custodian, confirmation service provider, etc. This can be extended to provide custom roles.
 *
 */
@RosettaDataType(value="LoanTradingPartyRole", builder=LoanTradingPartyRole.LoanTradingPartyRoleBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanTradingPartyRole", model="fpml", builder=LoanTradingPartyRole.LoanTradingPartyRoleBuilderImpl.class, version="2.1.1")
public interface LoanTradingPartyRole extends RosettaModelObject {

	LoanTradingPartyRoleMeta metaData = new LoanTradingPartyRoleMeta();

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
	String getTradingPartyRoleScheme();

	/*********************** Build Methods  ***********************/
	LoanTradingPartyRole build();
	
	LoanTradingPartyRole.LoanTradingPartyRoleBuilder toBuilder();
	
	static LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder() {
		return new LoanTradingPartyRole.LoanTradingPartyRoleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanTradingPartyRole> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanTradingPartyRole> getType() {
		return LoanTradingPartyRole.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("tradingPartyRoleScheme"), String.class, getTradingPartyRoleScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanTradingPartyRoleBuilder extends LoanTradingPartyRole, RosettaModelObjectBuilder {
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder setValue(String value);
		LoanTradingPartyRole.LoanTradingPartyRoleBuilder setTradingPartyRoleScheme(String tradingPartyRoleScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("tradingPartyRoleScheme"), String.class, getTradingPartyRoleScheme(), this);
		}
		

		LoanTradingPartyRole.LoanTradingPartyRoleBuilder prune();
	}

	/*********************** Immutable Implementation of LoanTradingPartyRole  ***********************/
	class LoanTradingPartyRoleImpl implements LoanTradingPartyRole {
		private final String value;
		private final String tradingPartyRoleScheme;
		
		protected LoanTradingPartyRoleImpl(LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder) {
			this.value = builder.getValue();
			this.tradingPartyRoleScheme = builder.getTradingPartyRoleScheme();
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
		@RosettaAttribute("tradingPartyRoleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingPartyRoleScheme")
		public String getTradingPartyRoleScheme() {
			return tradingPartyRoleScheme;
		}
		
		@Override
		public LoanTradingPartyRole build() {
			return this;
		}
		
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder toBuilder() {
			LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanTradingPartyRole.LoanTradingPartyRoleBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getTradingPartyRoleScheme()).ifPresent(builder::setTradingPartyRoleScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingPartyRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradingPartyRoleScheme, _that.getTradingPartyRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradingPartyRoleScheme != null ? tradingPartyRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingPartyRole {" +
				"value=" + this.value + ", " +
				"tradingPartyRoleScheme=" + this.tradingPartyRoleScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanTradingPartyRole  ***********************/
	class LoanTradingPartyRoleBuilderImpl implements LoanTradingPartyRole.LoanTradingPartyRoleBuilder {
	
		protected String value;
		protected String tradingPartyRoleScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("tradingPartyRoleScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradingPartyRoleScheme")
		public String getTradingPartyRoleScheme() {
			return tradingPartyRoleScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("tradingPartyRoleScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradingPartyRoleScheme")
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder setTradingPartyRoleScheme(String _tradingPartyRoleScheme) {
			this.tradingPartyRoleScheme = _tradingPartyRoleScheme == null ? null : _tradingPartyRoleScheme;
			return this;
		}
		
		@Override
		public LoanTradingPartyRole build() {
			return new LoanTradingPartyRole.LoanTradingPartyRoleImpl(this);
		}
		
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getTradingPartyRoleScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanTradingPartyRole.LoanTradingPartyRoleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanTradingPartyRole.LoanTradingPartyRoleBuilder o = (LoanTradingPartyRole.LoanTradingPartyRoleBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getTradingPartyRoleScheme(), o.getTradingPartyRoleScheme(), this::setTradingPartyRoleScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanTradingPartyRole _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(tradingPartyRoleScheme, _that.getTradingPartyRoleScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (tradingPartyRoleScheme != null ? tradingPartyRoleScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanTradingPartyRoleBuilder {" +
				"value=" + this.value + ", " +
				"tradingPartyRoleScheme=" + this.tradingPartyRoleScheme +
			'}';
		}
	}
}
