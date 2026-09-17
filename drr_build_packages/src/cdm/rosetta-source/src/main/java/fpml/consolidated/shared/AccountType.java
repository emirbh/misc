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
import fpml.consolidated.shared.meta.AccountTypeMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for account type.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for account type.
 *
 */
@RosettaDataType(value="AccountType", builder=AccountType.AccountTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccountType", model="fpml", builder=AccountType.AccountTypeBuilderImpl.class, version="2.1.1")
public interface AccountType extends RosettaModelObject {

	AccountTypeMeta metaData = new AccountTypeMeta();

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
	 * Provision The identifier scheme used with this accountType. A unique URI to determine the the type of account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The identifier scheme used with this accountType. A unique URI to determine the the type of account.
	 *
	 */
	String getAccountTypeScheme();

	/*********************** Build Methods  ***********************/
	AccountType build();
	
	AccountType.AccountTypeBuilder toBuilder();
	
	static AccountType.AccountTypeBuilder builder() {
		return new AccountType.AccountTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccountType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccountType> getType() {
		return AccountType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accountTypeScheme"), String.class, getAccountTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountTypeBuilder extends AccountType, RosettaModelObjectBuilder {
		AccountType.AccountTypeBuilder setValue(String value);
		AccountType.AccountTypeBuilder setAccountTypeScheme(String accountTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accountTypeScheme"), String.class, getAccountTypeScheme(), this);
		}
		

		AccountType.AccountTypeBuilder prune();
	}

	/*********************** Immutable Implementation of AccountType  ***********************/
	class AccountTypeImpl implements AccountType {
		private final String value;
		private final String accountTypeScheme;
		
		protected AccountTypeImpl(AccountType.AccountTypeBuilder builder) {
			this.value = builder.getValue();
			this.accountTypeScheme = builder.getAccountTypeScheme();
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
		@RosettaAttribute("accountTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountTypeScheme")
		public String getAccountTypeScheme() {
			return accountTypeScheme;
		}
		
		@Override
		public AccountType build() {
			return this;
		}
		
		@Override
		public AccountType.AccountTypeBuilder toBuilder() {
			AccountType.AccountTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccountType.AccountTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccountTypeScheme()).ifPresent(builder::setAccountTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountTypeScheme, _that.getAccountTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountTypeScheme != null ? accountTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountType {" +
				"value=" + this.value + ", " +
				"accountTypeScheme=" + this.accountTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccountType  ***********************/
	class AccountTypeBuilderImpl implements AccountType.AccountTypeBuilder {
	
		protected String value;
		protected String accountTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accountTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountTypeScheme")
		public String getAccountTypeScheme() {
			return accountTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public AccountType.AccountTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("accountTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountTypeScheme")
		@Override
		public AccountType.AccountTypeBuilder setAccountTypeScheme(String _accountTypeScheme) {
			this.accountTypeScheme = _accountTypeScheme == null ? null : _accountTypeScheme;
			return this;
		}
		
		@Override
		public AccountType build() {
			return new AccountType.AccountTypeImpl(this);
		}
		
		@Override
		public AccountType.AccountTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountType.AccountTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccountTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountType.AccountTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccountType.AccountTypeBuilder o = (AccountType.AccountTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccountTypeScheme(), o.getAccountTypeScheme(), this::setAccountTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountTypeScheme, _that.getAccountTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountTypeScheme != null ? accountTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountTypeBuilder {" +
				"value=" + this.value + ", " +
				"accountTypeScheme=" + this.accountTypeScheme +
			'}';
		}
	}
}
