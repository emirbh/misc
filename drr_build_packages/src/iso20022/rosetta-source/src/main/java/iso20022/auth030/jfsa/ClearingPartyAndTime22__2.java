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
import iso20022.auth030.jfsa.meta.ClearingPartyAndTime22__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingPartyAndTime22__2", builder=ClearingPartyAndTime22__2.ClearingPartyAndTime22__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingPartyAndTime22__2", model="iso20022", builder=ClearingPartyAndTime22__2.ClearingPartyAndTime22__2BuilderImpl.class, version="${project.version}")
public interface ClearingPartyAndTime22__2 extends RosettaModelObject {

	ClearingPartyAndTime22__2Meta metaData = new ClearingPartyAndTime22__2Meta();

	/*********************** Getter Methods  ***********************/
	OrganisationIdentification15Choice__1 getCcp();
	UniqueTransactionIdentifier2Choice__1 getOrgnlIdr();
	OrganisationIdentification15Choice__1 getOrgnlTradRpstryIdr();
	ClearingAccountType4Code getClrAcctOrgn();

	/*********************** Build Methods  ***********************/
	ClearingPartyAndTime22__2 build();
	
	ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder toBuilder();
	
	static ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder builder() {
		return new ClearingPartyAndTime22__2.ClearingPartyAndTime22__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingPartyAndTime22__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingPartyAndTime22__2> getType() {
		return ClearingPartyAndTime22__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__1.class, getCcp());
		processRosetta(path.newSubPath("orgnlIdr"), processor, UniqueTransactionIdentifier2Choice__1.class, getOrgnlIdr());
		processRosetta(path.newSubPath("orgnlTradRpstryIdr"), processor, OrganisationIdentification15Choice__1.class, getOrgnlTradRpstryIdr());
		processor.processBasic(path.newSubPath("clrAcctOrgn"), ClearingAccountType4Code.class, getClrAcctOrgn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingPartyAndTime22__2Builder extends ClearingPartyAndTime22__2, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateCcp();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getCcp();
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateOrgnlIdr();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrgnlIdr();
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrCreateOrgnlTradRpstryIdr();
		@Override
		OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder getOrgnlTradRpstryIdr();
		ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setCcp(OrganisationIdentification15Choice__1 ccp);
		ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setOrgnlIdr(UniqueTransactionIdentifier2Choice__1 orgnlIdr);
		ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setOrgnlTradRpstryIdr(OrganisationIdentification15Choice__1 orgnlTradRpstryIdr);
		ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setClrAcctOrgn(ClearingAccountType4Code clrAcctOrgn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getCcp());
			processRosetta(path.newSubPath("orgnlIdr"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getOrgnlIdr());
			processRosetta(path.newSubPath("orgnlTradRpstryIdr"), processor, OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder.class, getOrgnlTradRpstryIdr());
			processor.processBasic(path.newSubPath("clrAcctOrgn"), ClearingAccountType4Code.class, getClrAcctOrgn(), this);
		}
		

		ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder prune();
	}

	/*********************** Immutable Implementation of ClearingPartyAndTime22__2  ***********************/
	class ClearingPartyAndTime22__2Impl implements ClearingPartyAndTime22__2 {
		private final OrganisationIdentification15Choice__1 ccp;
		private final UniqueTransactionIdentifier2Choice__1 orgnlIdr;
		private final OrganisationIdentification15Choice__1 orgnlTradRpstryIdr;
		private final ClearingAccountType4Code clrAcctOrgn;
		
		protected ClearingPartyAndTime22__2Impl(ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder builder) {
			this.ccp = ofNullable(builder.getCcp()).map(f->f.build()).orElse(null);
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
		public ClearingPartyAndTime22__2 build() {
			return this;
		}
		
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder toBuilder() {
			ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder builder) {
			ofNullable(getCcp()).ifPresent(builder::setCcp);
			ofNullable(getOrgnlIdr()).ifPresent(builder::setOrgnlIdr);
			ofNullable(getOrgnlTradRpstryIdr()).ifPresent(builder::setOrgnlTradRpstryIdr);
			ofNullable(getClrAcctOrgn()).ifPresent(builder::setClrAcctOrgn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22__2 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			if (!Objects.equals(orgnlIdr, _that.getOrgnlIdr())) return false;
			if (!Objects.equals(orgnlTradRpstryIdr, _that.getOrgnlTradRpstryIdr())) return false;
			if (!Objects.equals(clrAcctOrgn, _that.getClrAcctOrgn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			_result = 31 * _result + (orgnlIdr != null ? orgnlIdr.hashCode() : 0);
			_result = 31 * _result + (orgnlTradRpstryIdr != null ? orgnlTradRpstryIdr.hashCode() : 0);
			_result = 31 * _result + (clrAcctOrgn != null ? clrAcctOrgn.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime22__2 {" +
				"ccp=" + this.ccp + ", " +
				"orgnlIdr=" + this.orgnlIdr + ", " +
				"orgnlTradRpstryIdr=" + this.orgnlTradRpstryIdr + ", " +
				"clrAcctOrgn=" + this.clrAcctOrgn +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingPartyAndTime22__2  ***********************/
	class ClearingPartyAndTime22__2BuilderImpl implements ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder {
	
		protected OrganisationIdentification15Choice__1.OrganisationIdentification15Choice__1Builder ccp;
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
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setCcp(OrganisationIdentification15Choice__1 _ccp) {
			this.ccp = _ccp == null ? null : _ccp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("orgnlIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orgnlIdr")
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setOrgnlIdr(UniqueTransactionIdentifier2Choice__1 _orgnlIdr) {
			this.orgnlIdr = _orgnlIdr == null ? null : _orgnlIdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("orgnlTradRpstryIdr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("orgnlTradRpstryIdr")
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setOrgnlTradRpstryIdr(OrganisationIdentification15Choice__1 _orgnlTradRpstryIdr) {
			this.orgnlTradRpstryIdr = _orgnlTradRpstryIdr == null ? null : _orgnlTradRpstryIdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clrAcctOrgn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrAcctOrgn")
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder setClrAcctOrgn(ClearingAccountType4Code _clrAcctOrgn) {
			this.clrAcctOrgn = _clrAcctOrgn == null ? null : _clrAcctOrgn;
			return this;
		}
		
		@Override
		public ClearingPartyAndTime22__2 build() {
			return new ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Impl(this);
		}
		
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder prune() {
			if (ccp!=null && !ccp.prune().hasData()) ccp = null;
			if (orgnlIdr!=null && !orgnlIdr.prune().hasData()) orgnlIdr = null;
			if (orgnlTradRpstryIdr!=null && !orgnlTradRpstryIdr.prune().hasData()) orgnlTradRpstryIdr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCcp()!=null && getCcp().hasData()) return true;
			if (getOrgnlIdr()!=null && getOrgnlIdr().hasData()) return true;
			if (getOrgnlTradRpstryIdr()!=null && getOrgnlTradRpstryIdr().hasData()) return true;
			if (getClrAcctOrgn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder o = (ClearingPartyAndTime22__2.ClearingPartyAndTime22__2Builder) other;
			
			merger.mergeRosetta(getCcp(), o.getCcp(), this::setCcp);
			merger.mergeRosetta(getOrgnlIdr(), o.getOrgnlIdr(), this::setOrgnlIdr);
			merger.mergeRosetta(getOrgnlTradRpstryIdr(), o.getOrgnlTradRpstryIdr(), this::setOrgnlTradRpstryIdr);
			
			merger.mergeBasic(getClrAcctOrgn(), o.getClrAcctOrgn(), this::setClrAcctOrgn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22__2 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			if (!Objects.equals(orgnlIdr, _that.getOrgnlIdr())) return false;
			if (!Objects.equals(orgnlTradRpstryIdr, _that.getOrgnlTradRpstryIdr())) return false;
			if (!Objects.equals(clrAcctOrgn, _that.getClrAcctOrgn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			_result = 31 * _result + (orgnlIdr != null ? orgnlIdr.hashCode() : 0);
			_result = 31 * _result + (orgnlTradRpstryIdr != null ? orgnlTradRpstryIdr.hashCode() : 0);
			_result = 31 * _result + (clrAcctOrgn != null ? clrAcctOrgn.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime22__2Builder {" +
				"ccp=" + this.ccp + ", " +
				"orgnlIdr=" + this.orgnlIdr + ", " +
				"orgnlTradRpstryIdr=" + this.orgnlTradRpstryIdr + ", " +
				"clrAcctOrgn=" + this.clrAcctOrgn +
			'}';
		}
	}
}
