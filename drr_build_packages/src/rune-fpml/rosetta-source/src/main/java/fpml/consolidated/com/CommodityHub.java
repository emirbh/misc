package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.CommodityHubMeta;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a hub or other reference for a physically settled commodity trade.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a hub or other reference for a physically settled commodity trade.
 *
 */
@RosettaDataType(value="CommodityHub", builder=CommodityHub.CommodityHubBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityHub", model="fpml", builder=CommodityHub.CommodityHubBuilderImpl.class, version="2.1.1")
public interface CommodityHub extends RosettaModelObject {

	CommodityHubMeta metaData = new CommodityHubMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a party.
	 *
	 */
	PartyReference getPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to an account.
	 *
	 */
	AccountReference getAccountReference();
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
	CommodityHubCode getHubCode();

	/*********************** Build Methods  ***********************/
	CommodityHub build();
	
	CommodityHub.CommodityHubBuilder toBuilder();
	
	static CommodityHub.CommodityHubBuilder builder() {
		return new CommodityHub.CommodityHubBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityHub> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityHub> getType() {
		return CommodityHub.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
		processRosetta(path.newSubPath("hubCode"), processor, CommodityHubCode.class, getHubCode());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityHubBuilder extends CommodityHub, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getAccountReference();
		CommodityHubCode.CommodityHubCodeBuilder getOrCreateHubCode();
		@Override
		CommodityHubCode.CommodityHubCodeBuilder getHubCode();
		CommodityHub.CommodityHubBuilder setPartyReference(PartyReference partyReference);
		CommodityHub.CommodityHubBuilder setAccountReference(AccountReference accountReference);
		CommodityHub.CommodityHubBuilder setHubCode(CommodityHubCode hubCode);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
			processRosetta(path.newSubPath("hubCode"), processor, CommodityHubCode.CommodityHubCodeBuilder.class, getHubCode());
		}
		

		CommodityHub.CommodityHubBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityHub  ***********************/
	class CommodityHubImpl implements CommodityHub {
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		private final CommodityHubCode hubCode;
		
		protected CommodityHubImpl(CommodityHub.CommodityHubBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
			this.hubCode = ofNullable(builder.getHubCode()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		@RosettaAttribute("hubCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hubCode")
		public CommodityHubCode getHubCode() {
			return hubCode;
		}
		
		@Override
		public CommodityHub build() {
			return this;
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder toBuilder() {
			CommodityHub.CommodityHubBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityHub.CommodityHubBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
			ofNullable(getHubCode()).ifPresent(builder::setHubCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityHub _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(hubCode, _that.getHubCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (hubCode != null ? hubCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityHub {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"hubCode=" + this.hubCode +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityHub  ***********************/
	class CommodityHubBuilderImpl implements CommodityHub.CommodityHubBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
		protected CommodityHubCode.CommodityHubCodeBuilder hubCode;
		
		@Override
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("hubCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hubCode")
		public CommodityHubCode.CommodityHubCodeBuilder getHubCode() {
			return hubCode;
		}
		
		@Override
		public CommodityHubCode.CommodityHubCodeBuilder getOrCreateHubCode() {
			CommodityHubCode.CommodityHubCodeBuilder result;
			if (hubCode!=null) {
				result = hubCode;
			}
			else {
				result = hubCode = CommodityHubCode.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("partyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("partyReference")
		@Override
		public CommodityHub.CommodityHubBuilder setPartyReference(PartyReference _partyReference) {
			this.partyReference = _partyReference == null ? null : _partyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("accountReference")
		@Override
		public CommodityHub.CommodityHubBuilder setAccountReference(AccountReference _accountReference) {
			this.accountReference = _accountReference == null ? null : _accountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("hubCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hubCode")
		@Override
		public CommodityHub.CommodityHubBuilder setHubCode(CommodityHubCode _hubCode) {
			this.hubCode = _hubCode == null ? null : _hubCode.toBuilder();
			return this;
		}
		
		@Override
		public CommodityHub build() {
			return new CommodityHub.CommodityHubImpl(this);
		}
		
		@Override
		public CommodityHub.CommodityHubBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityHub.CommodityHubBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			if (hubCode!=null && !hubCode.prune().hasData()) hubCode = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			if (getHubCode()!=null && getHubCode().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityHub.CommodityHubBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityHub.CommodityHubBuilder o = (CommodityHub.CommodityHubBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			merger.mergeRosetta(getHubCode(), o.getHubCode(), this::setHubCode);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityHub _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			if (!Objects.equals(hubCode, _that.getHubCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			_result = 31 * _result + (hubCode != null ? hubCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityHubBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference + ", " +
				"hubCode=" + this.hubCode +
			'}';
		}
	}
}
