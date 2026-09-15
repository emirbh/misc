package iso20022.auth030.jfsa;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.jfsa.meta.ClearingPartyAndTime22__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingPartyAndTime22__1", builder=ClearingPartyAndTime22__1.ClearingPartyAndTime22__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingPartyAndTime22__1", model="iso20022", builder=ClearingPartyAndTime22__1.ClearingPartyAndTime22__1BuilderImpl.class, version="${project.version}")
public interface ClearingPartyAndTime22__1 extends RosettaModelObject {

	ClearingPartyAndTime22__1Meta metaData = new ClearingPartyAndTime22__1Meta();

	/*********************** Getter Methods  ***********************/
	OrganisationIdentification15Choice__1 getCcp();
	ZonedDateTime getClrRctDtTm();
	UniqueTransactionIdentifier2Choice__1 getOrgnlIdr();
	OrganisationIdentification15Choice__1 getOrgnlTradRpstryIdr();
	ClearingAccountType4Code getClrAcctOrgn();

	/*********************** Build Methods  ***********************/
	ClearingPartyAndTime22__1 build();
	
	ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder toBuilder();
	
	static ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder builder() {
		return new ClearingPartyAndTime22__1.ClearingPartyAndTime22__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingPartyAndTime22__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingPartyAndTime22__1> getType() {
		return ClearingPartyAndTime22__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__1.class, getCcp());
		processor.processBasic(path.newSubPath("clrRctDtTm"), ZonedDateTime.class, getClrRctDtTm(), this);
		processRosetta(path.newSubPath("orgnlIdr"), processor, UniqueTransactionIdentifier2Choice__1.class, getOrgnlIdr());
		processRosetta(path.newSubPath("orgnlTradRpstryIdr"), processor, OrganisationIdentification15Choice__1.class, getOrgnlTradRpstryIdr());
		processor.processBasic(path.newSubPath("clrAcctOrgn"), ClearingAccountType4Code.class, getClrAcctOrgn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingPartyAndTime22__1Builder extends ClearingPartyAndTime22__1, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateCcp();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getCcp();
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateOrgnlIdr();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrgnlIdr();
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateOrgnlTradRpstryIdr();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrgnlTradRpstryIdr();
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setCcp(OrganisationIdentification15Choice__1 ccp);
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setClrRctDtTm(ZonedDateTime clrRctDtTm);
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setOrgnlIdr(UniqueTransactionIdentifier2Choice__1 orgnlIdr);
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setOrgnlTradRpstryIdr(OrganisationIdentification15Choice__1 orgnlTradRpstryIdr);
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setClrAcctOrgn(ClearingAccountType4Code clrAcctOrgn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getCcp());
			processor.processBasic(path.newSubPath("clrRctDtTm"), ZonedDateTime.class, getClrRctDtTm(), this);
			processRosetta(path.newSubPath("orgnlIdr"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getOrgnlIdr());
			processRosetta(path.newSubPath("orgnlTradRpstryIdr"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getOrgnlTradRpstryIdr());
			processor.processBasic(path.newSubPath("clrAcctOrgn"), ClearingAccountType4Code.class, getClrAcctOrgn(), this);
		}
		

		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder prune();
	}

	/*********************** Immutable Implementation of ClearingPartyAndTime22__1  ***********************/
	class ClearingPartyAndTime22__1Impl implements ClearingPartyAndTime22__1 {
		private final OrganisationIdentification15Choice__1 ccp;
		private final ZonedDateTime clrRctDtTm;
		private final UniqueTransactionIdentifier2Choice__1 orgnlIdr;
		private final OrganisationIdentification15Choice__1 orgnlTradRpstryIdr;
		private final ClearingAccountType4Code clrAcctOrgn;
		
		protected ClearingPartyAndTime22__1Impl(ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder builder) {
			this.ccp = ofNullable(builder.getCcp()).map(f->f.build()).orElse(null);
			this.clrRctDtTm = builder.getClrRctDtTm();
			this.orgnlIdr = ofNullable(builder.getOrgnlIdr()).map(f->f.build()).orElse(null);
			this.orgnlTradRpstryIdr = ofNullable(builder.getOrgnlTradRpstryIdr()).map(f->f.build()).orElse(null);
			this.clrAcctOrgn = builder.getClrAcctOrgn();
		}
		
		@Override
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ccp")
		public OrganisationIdentification15Choice__1 getCcp() {
			return ccp;
		}
		
		@Override
		@RosettaAttribute("clrRctDtTm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrRctDtTm")
		public ZonedDateTime getClrRctDtTm() {
			return clrRctDtTm;
		}
		
		@Override
		@RosettaAttribute("orgnlIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orgnlIdr")
		public UniqueTransactionIdentifier2Choice__1 getOrgnlIdr() {
			return orgnlIdr;
		}
		
		@Override
		@RosettaAttribute("orgnlTradRpstryIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orgnlTradRpstryIdr")
		public OrganisationIdentification15Choice__1 getOrgnlTradRpstryIdr() {
			return orgnlTradRpstryIdr;
		}
		
		@Override
		@RosettaAttribute("clrAcctOrgn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrAcctOrgn")
		public ClearingAccountType4Code getClrAcctOrgn() {
			return clrAcctOrgn;
		}
		
		@Override
		public ClearingPartyAndTime22__1 build() {
			return this;
		}
		
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder toBuilder() {
			ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder builder) {
			ofNullable(getCcp()).ifPresent(builder::setCcp);
			ofNullable(getClrRctDtTm()).ifPresent(builder::setClrRctDtTm);
			ofNullable(getOrgnlIdr()).ifPresent(builder::setOrgnlIdr);
			ofNullable(getOrgnlTradRpstryIdr()).ifPresent(builder::setOrgnlTradRpstryIdr);
			ofNullable(getClrAcctOrgn()).ifPresent(builder::setClrAcctOrgn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			if (!Objects.equals(clrRctDtTm, _that.getClrRctDtTm())) return false;
			if (!Objects.equals(orgnlIdr, _that.getOrgnlIdr())) return false;
			if (!Objects.equals(orgnlTradRpstryIdr, _that.getOrgnlTradRpstryIdr())) return false;
			if (!Objects.equals(clrAcctOrgn, _that.getClrAcctOrgn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			_result = 31 * _result + (clrRctDtTm != null ? clrRctDtTm.hashCode() : 0);
			_result = 31 * _result + (orgnlIdr != null ? orgnlIdr.hashCode() : 0);
			_result = 31 * _result + (orgnlTradRpstryIdr != null ? orgnlTradRpstryIdr.hashCode() : 0);
			_result = 31 * _result + (clrAcctOrgn != null ? clrAcctOrgn.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime22__1 {" +
				"ccp=" + this.ccp + ", " +
				"clrRctDtTm=" + this.clrRctDtTm + ", " +
				"orgnlIdr=" + this.orgnlIdr + ", " +
				"orgnlTradRpstryIdr=" + this.orgnlTradRpstryIdr + ", " +
				"clrAcctOrgn=" + this.clrAcctOrgn +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingPartyAndTime22__1  ***********************/
	class ClearingPartyAndTime22__1BuilderImpl implements ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder {
	
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder ccp;
		protected ZonedDateTime clrRctDtTm;
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder orgnlIdr;
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder orgnlTradRpstryIdr;
		protected ClearingAccountType4Code clrAcctOrgn;
		
		@Override
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ccp")
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getCcp() {
			return ccp;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateCcp() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder result;
			if (ccp!=null) {
				result = ccp;
			}
			else {
				result = ccp = OrganisationIdentification15Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clrRctDtTm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrRctDtTm")
		public ZonedDateTime getClrRctDtTm() {
			return clrRctDtTm;
		}
		
		@Override
		@RosettaAttribute("orgnlIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orgnlIdr")
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrgnlIdr() {
			return orgnlIdr;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateOrgnlIdr() {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder result;
			if (orgnlIdr!=null) {
				result = orgnlIdr;
			}
			else {
				result = orgnlIdr = UniqueTransactionIdentifier2Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("orgnlTradRpstryIdr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("orgnlTradRpstryIdr")
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrgnlTradRpstryIdr() {
			return orgnlTradRpstryIdr;
		}
		
		@Override
		public OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateOrgnlTradRpstryIdr() {
			OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder result;
			if (orgnlTradRpstryIdr!=null) {
				result = orgnlTradRpstryIdr;
			}
			else {
				result = orgnlTradRpstryIdr = OrganisationIdentification15Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clrAcctOrgn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrAcctOrgn")
		public ClearingAccountType4Code getClrAcctOrgn() {
			return clrAcctOrgn;
		}
		
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ccp")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setCcp(OrganisationIdentification15Choice__1 _ccp) {
			this.ccp = _ccp == null ? null : _ccp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clrRctDtTm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrRctDtTm")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setClrRctDtTm(ZonedDateTime _clrRctDtTm) {
			this.clrRctDtTm = _clrRctDtTm == null ? null : _clrRctDtTm;
			return this;
		}
		
		@RosettaAttribute("orgnlIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orgnlIdr")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setOrgnlIdr(UniqueTransactionIdentifier2Choice__1 _orgnlIdr) {
			this.orgnlIdr = _orgnlIdr == null ? null : _orgnlIdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("orgnlTradRpstryIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orgnlTradRpstryIdr")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setOrgnlTradRpstryIdr(OrganisationIdentification15Choice__1 _orgnlTradRpstryIdr) {
			this.orgnlTradRpstryIdr = _orgnlTradRpstryIdr == null ? null : _orgnlTradRpstryIdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clrAcctOrgn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrAcctOrgn")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setClrAcctOrgn(ClearingAccountType4Code _clrAcctOrgn) {
			this.clrAcctOrgn = _clrAcctOrgn == null ? null : _clrAcctOrgn;
			return this;
		}
		
		@Override
		public ClearingPartyAndTime22__1 build() {
			return new ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Impl(this);
		}
		
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder prune() {
			if (ccp!=null && !ccp.prune().hasData()) ccp = null;
			if (orgnlIdr!=null && !orgnlIdr.prune().hasData()) orgnlIdr = null;
			if (orgnlTradRpstryIdr!=null && !orgnlTradRpstryIdr.prune().hasData()) orgnlTradRpstryIdr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCcp()!=null && getCcp().hasData()) return true;
			if (getClrRctDtTm()!=null) return true;
			if (getOrgnlIdr()!=null && getOrgnlIdr().hasData()) return true;
			if (getOrgnlTradRpstryIdr()!=null && getOrgnlTradRpstryIdr().hasData()) return true;
			if (getClrAcctOrgn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder o = (ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder) other;
			
			merger.mergeRosetta(getCcp(), o.getCcp(), this::setCcp);
			merger.mergeRosetta(getOrgnlIdr(), o.getOrgnlIdr(), this::setOrgnlIdr);
			merger.mergeRosetta(getOrgnlTradRpstryIdr(), o.getOrgnlTradRpstryIdr(), this::setOrgnlTradRpstryIdr);
			
			merger.mergeBasic(getClrRctDtTm(), o.getClrRctDtTm(), this::setClrRctDtTm);
			merger.mergeBasic(getClrAcctOrgn(), o.getClrAcctOrgn(), this::setClrAcctOrgn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			if (!Objects.equals(clrRctDtTm, _that.getClrRctDtTm())) return false;
			if (!Objects.equals(orgnlIdr, _that.getOrgnlIdr())) return false;
			if (!Objects.equals(orgnlTradRpstryIdr, _that.getOrgnlTradRpstryIdr())) return false;
			if (!Objects.equals(clrAcctOrgn, _that.getClrAcctOrgn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			_result = 31 * _result + (clrRctDtTm != null ? clrRctDtTm.hashCode() : 0);
			_result = 31 * _result + (orgnlIdr != null ? orgnlIdr.hashCode() : 0);
			_result = 31 * _result + (orgnlTradRpstryIdr != null ? orgnlTradRpstryIdr.hashCode() : 0);
			_result = 31 * _result + (clrAcctOrgn != null ? clrAcctOrgn.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime22__1Builder {" +
				"ccp=" + this.ccp + ", " +
				"clrRctDtTm=" + this.clrRctDtTm + ", " +
				"orgnlIdr=" + this.orgnlIdr + ", " +
				"orgnlTradRpstryIdr=" + this.orgnlTradRpstryIdr + ", " +
				"clrAcctOrgn=" + this.clrAcctOrgn +
			'}';
		}
	}
}
