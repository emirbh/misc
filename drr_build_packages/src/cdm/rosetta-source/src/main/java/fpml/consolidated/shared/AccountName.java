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
import fpml.consolidated.shared.meta.AccountNameMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for the name of the account.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for the name of the account.
 *
 */
@RosettaDataType(value="AccountName", builder=AccountName.AccountNameBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AccountName", model="fpml", builder=AccountName.AccountNameBuilderImpl.class, version="2.1.1")
public interface AccountName extends RosettaModelObject {

	AccountNameMeta metaData = new AccountNameMeta();

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
	 * Provision The identifier scheme used with this accountName. A unique URI to determine the source of the account name.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The identifier scheme used with this accountName. A unique URI to determine the source of the account name.
	 *
	 */
	String getAccountNameScheme();

	/*********************** Build Methods  ***********************/
	AccountName build();
	
	AccountName.AccountNameBuilder toBuilder();
	
	static AccountName.AccountNameBuilder builder() {
		return new AccountName.AccountNameBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccountName> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AccountName> getType() {
		return AccountName.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("accountNameScheme"), String.class, getAccountNameScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountNameBuilder extends AccountName, RosettaModelObjectBuilder {
		AccountName.AccountNameBuilder setValue(String value);
		AccountName.AccountNameBuilder setAccountNameScheme(String accountNameScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("accountNameScheme"), String.class, getAccountNameScheme(), this);
		}
		

		AccountName.AccountNameBuilder prune();
	}

	/*********************** Immutable Implementation of AccountName  ***********************/
	class AccountNameImpl implements AccountName {
		private final String value;
		private final String accountNameScheme;
		
		protected AccountNameImpl(AccountName.AccountNameBuilder builder) {
			this.value = builder.getValue();
			this.accountNameScheme = builder.getAccountNameScheme();
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
		@RosettaAttribute("accountNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountNameScheme")
		public String getAccountNameScheme() {
			return accountNameScheme;
		}
		
		@Override
		public AccountName build() {
			return this;
		}
		
		@Override
		public AccountName.AccountNameBuilder toBuilder() {
			AccountName.AccountNameBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccountName.AccountNameBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getAccountNameScheme()).ifPresent(builder::setAccountNameScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountNameScheme, _that.getAccountNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountNameScheme != null ? accountNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountName {" +
				"value=" + this.value + ", " +
				"accountNameScheme=" + this.accountNameScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of AccountName  ***********************/
	class AccountNameBuilderImpl implements AccountName.AccountNameBuilder {
	
		protected String value;
		protected String accountNameScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("accountNameScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountNameScheme")
		public String getAccountNameScheme() {
			return accountNameScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public AccountName.AccountNameBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("accountNameScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountNameScheme")
		@Override
		public AccountName.AccountNameBuilder setAccountNameScheme(String _accountNameScheme) {
			this.accountNameScheme = _accountNameScheme == null ? null : _accountNameScheme;
			return this;
		}
		
		@Override
		public AccountName build() {
			return new AccountName.AccountNameImpl(this);
		}
		
		@Override
		public AccountName.AccountNameBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountName.AccountNameBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getAccountNameScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountName.AccountNameBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccountName.AccountNameBuilder o = (AccountName.AccountNameBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getAccountNameScheme(), o.getAccountNameScheme(), this::setAccountNameScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountName _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(accountNameScheme, _that.getAccountNameScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (accountNameScheme != null ? accountNameScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountNameBuilder {" +
				"value=" + this.value + ", " +
				"accountNameScheme=" + this.accountNameScheme +
			'}';
		}
	}
}
