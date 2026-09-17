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
import fpml.consolidated.shared.meta.AccountIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for account identifiers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for account identifiers.
 *
 */
@RosettaDataType(value="AccountId", builder=AccountId.AccountIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccountId", model="fpml", builder=AccountId.AccountIdBuilderImpl.class, version="2.1.1")
public interface AccountId extends RosettaModelObject {

	AccountIdMeta metaData = new AccountIdMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision The identifier scheme used with this accountId. A unique URI to determine the authoritative issuer of these identifiers.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The identifier scheme used with this accountId. A unique URI to determine the authoritative issuer of these identifiers.
	 *
	 */
	String getAccountIdScheme();

	/*********************** Build Methods  ***********************/
	AccountId build();
	
	AccountId.AccountIdBuilder toBuilder();
	
	static AccountId.AccountIdBuilder builder() {
		return new AccountId.AccountIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccountId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccountId> getType() {
		return AccountId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accountIdScheme"), String.class, getAccountIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountIdBuilder extends AccountId, RosettaModelObjectBuilder {
		AccountId.AccountIdBuilder setValue(String value);
		AccountId.AccountIdBuilder setAccountIdScheme(String accountIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accountIdScheme"), String.class, getAccountIdScheme(), this);
		}
		

		AccountId.AccountIdBuilder prune();
	}

	/*********************** Immutable Implementation of AccountId  ***********************/
	class AccountIdImpl implements AccountId {
		private final String value;
		private final String accountIdScheme;
		
		protected AccountIdImpl(AccountId.AccountIdBuilder builder) {
			this.value = builder.getValue();
			this.accountIdScheme = builder.getAccountIdScheme();
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
		@RosettaAttribute("accountIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountIdScheme")
		public String getAccountIdScheme() {
			return accountIdScheme;
		}
		
		@Override
		public AccountId build() {
			return this;
		}
		
		@Override
		public AccountId.AccountIdBuilder toBuilder() {
			AccountId.AccountIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccountId.AccountIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccountIdScheme()).ifPresent(builder::setAccountIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountIdScheme, _that.getAccountIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountIdScheme != null ? accountIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountId {" +
				"value=" + this.value + ", " +
				"accountIdScheme=" + this.accountIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccountId  ***********************/
	class AccountIdBuilderImpl implements AccountId.AccountIdBuilder {
	
		protected String value;
		protected String accountIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accountIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountIdScheme")
		public String getAccountIdScheme() {
			return accountIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public AccountId.AccountIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("accountIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountIdScheme")
		@Override
		public AccountId.AccountIdBuilder setAccountIdScheme(String _accountIdScheme) {
			this.accountIdScheme = _accountIdScheme == null ? null : _accountIdScheme;
			return this;
		}
		
		@Override
		public AccountId build() {
			return new AccountId.AccountIdImpl(this);
		}
		
		@Override
		public AccountId.AccountIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountId.AccountIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccountIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountId.AccountIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccountId.AccountIdBuilder o = (AccountId.AccountIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccountIdScheme(), o.getAccountIdScheme(), this::setAccountIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountIdScheme, _that.getAccountIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountIdScheme != null ? accountIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountIdBuilder {" +
				"value=" + this.value + ", " +
				"accountIdScheme=" + this.accountIdScheme +
			'}';
		}
	}
}
