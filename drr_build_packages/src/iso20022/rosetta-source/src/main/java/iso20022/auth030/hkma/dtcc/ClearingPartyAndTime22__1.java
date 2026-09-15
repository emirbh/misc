package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.ClearingPartyAndTime22__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the central counterparty clearing time.
 * @version ${project.version}
 */
@RosettaDataType(value="ClearingPartyAndTime22__1", builder=ClearingPartyAndTime22__1.ClearingPartyAndTime22__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="ClearingPartyAndTime22__1", model="iso20022", builder=ClearingPartyAndTime22__1.ClearingPartyAndTime22__1BuilderImpl.class, version="${project.version}")
public interface ClearingPartyAndTime22__1 extends RosettaModelObject {

	ClearingPartyAndTime22__1Meta metaData = new ClearingPartyAndTime22__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the central counterparty (CCP) that cleared the transaction.
	 */
	OrganisationIdentification15Choice__3 getCcp();
	/**
	 * Time and date when clearing took place.
	 */
	ZonedDateTime getClrDtTm();

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
		processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__3.class, getCcp());
		processor.processBasic(path.newSubPath("clrDtTm"), ZonedDateTime.class, getClrDtTm(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingPartyAndTime22__1Builder extends ClearingPartyAndTime22__1, RosettaModelObjectBuilder {
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateCcp();
		@Override
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getCcp();
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setCcp(OrganisationIdentification15Choice__3 ccp);
		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setClrDtTm(ZonedDateTime clrDtTm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ccp"), processor, OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder.class, getCcp());
			processor.processBasic(path.newSubPath("clrDtTm"), ZonedDateTime.class, getClrDtTm(), this);
		}
		

		ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder prune();
	}

	/*********************** Immutable Implementation of ClearingPartyAndTime22__1  ***********************/
	class ClearingPartyAndTime22__1Impl implements ClearingPartyAndTime22__1 {
		private final OrganisationIdentification15Choice__3 ccp;
		private final ZonedDateTime clrDtTm;
		
		protected ClearingPartyAndTime22__1Impl(ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder builder) {
			this.ccp = ofNullable(builder.getCcp()).map(f->f.build()).orElse(null);
			this.clrDtTm = builder.getClrDtTm();
		}
		
		@Override
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccp")
		public OrganisationIdentification15Choice__3 getCcp() {
			return ccp;
		}
		
		@Override
		@RosettaAttribute("clrDtTm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrDtTm")
		public ZonedDateTime getClrDtTm() {
			return clrDtTm;
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
			ofNullable(getClrDtTm()).ifPresent(builder::setClrDtTm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			if (!Objects.equals(clrDtTm, _that.getClrDtTm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			_result = 31 * _result + (clrDtTm != null ? clrDtTm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime22__1 {" +
				"ccp=" + this.ccp + ", " +
				"clrDtTm=" + this.clrDtTm +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingPartyAndTime22__1  ***********************/
	class ClearingPartyAndTime22__1BuilderImpl implements ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder {
	
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder ccp;
		protected ZonedDateTime clrDtTm;
		
		@Override
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccp")
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getCcp() {
			return ccp;
		}
		
		@Override
		public OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder getOrCreateCcp() {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder result;
			if (ccp!=null) {
				result = ccp;
			}
			else {
				result = ccp = OrganisationIdentification15Choice__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clrDtTm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clrDtTm")
		public ZonedDateTime getClrDtTm() {
			return clrDtTm;
		}
		
		@RosettaAttribute("ccp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccp")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setCcp(OrganisationIdentification15Choice__3 _ccp) {
			this.ccp = _ccp == null ? null : _ccp.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clrDtTm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clrDtTm")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder setClrDtTm(ZonedDateTime _clrDtTm) {
			this.clrDtTm = _clrDtTm == null ? null : _clrDtTm;
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
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCcp()!=null && getCcp().hasData()) return true;
			if (getClrDtTm()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder o = (ClearingPartyAndTime22__1.ClearingPartyAndTime22__1Builder) other;
			
			merger.mergeRosetta(getCcp(), o.getCcp(), this::setCcp);
			
			merger.mergeBasic(getClrDtTm(), o.getClrDtTm(), this::setClrDtTm);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingPartyAndTime22__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccp, _that.getCcp())) return false;
			if (!Objects.equals(clrDtTm, _that.getClrDtTm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccp != null ? ccp.hashCode() : 0);
			_result = 31 * _result + (clrDtTm != null ? clrDtTm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingPartyAndTime22__1Builder {" +
				"ccp=" + this.ccp + ", " +
				"clrDtTm=" + this.clrDtTm +
			'}';
		}
	}
}
