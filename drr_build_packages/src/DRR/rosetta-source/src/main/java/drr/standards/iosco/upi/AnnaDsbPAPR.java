package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbPAPRMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbPAPR", builder=AnnaDsbPAPR.AnnaDsbPAPRBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbPAPR", model="drr", builder=AnnaDsbPAPR.AnnaDsbPAPRBuilderImpl.class, version="7.7.0")
public interface AnnaDsbPAPR extends RosettaModelObject {

	AnnaDsbPAPRMeta metaData = new AnnaDsbPAPRMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getPULP();
	AnnaDsbEmpty getNSPT();
	AnnaDsbEmpty getRCVP();
	AnnaDsbEmpty getCBRD();

	/*********************** Build Methods  ***********************/
	AnnaDsbPAPR build();
	
	AnnaDsbPAPR.AnnaDsbPAPRBuilder toBuilder();
	
	static AnnaDsbPAPR.AnnaDsbPAPRBuilder builder() {
		return new AnnaDsbPAPR.AnnaDsbPAPRBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbPAPR> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbPAPR> getType() {
		return AnnaDsbPAPR.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("PULP"), processor, AnnaDsbEmpty.class, getPULP());
		processRosetta(path.newSubPath("NSPT"), processor, AnnaDsbEmpty.class, getNSPT());
		processRosetta(path.newSubPath("RCVP"), processor, AnnaDsbEmpty.class, getRCVP());
		processRosetta(path.newSubPath("CBRD"), processor, AnnaDsbEmpty.class, getCBRD());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbPAPRBuilder extends AnnaDsbPAPR, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePULP();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getPULP();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateNSPT();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getNSPT();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateRCVP();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getRCVP();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCBRD();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getCBRD();
		AnnaDsbPAPR.AnnaDsbPAPRBuilder setPULP(AnnaDsbEmpty PULP);
		AnnaDsbPAPR.AnnaDsbPAPRBuilder setNSPT(AnnaDsbEmpty NSPT);
		AnnaDsbPAPR.AnnaDsbPAPRBuilder setRCVP(AnnaDsbEmpty RCVP);
		AnnaDsbPAPR.AnnaDsbPAPRBuilder setCBRD(AnnaDsbEmpty CBRD);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("PULP"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getPULP());
			processRosetta(path.newSubPath("NSPT"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getNSPT());
			processRosetta(path.newSubPath("RCVP"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getRCVP());
			processRosetta(path.newSubPath("CBRD"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getCBRD());
		}
		

		AnnaDsbPAPR.AnnaDsbPAPRBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbPAPR  ***********************/
	class AnnaDsbPAPRImpl implements AnnaDsbPAPR {
		private final AnnaDsbEmpty pULP;
		private final AnnaDsbEmpty nSPT;
		private final AnnaDsbEmpty rCVP;
		private final AnnaDsbEmpty cBRD;
		
		protected AnnaDsbPAPRImpl(AnnaDsbPAPR.AnnaDsbPAPRBuilder builder) {
			this.pULP = ofNullable(builder.getPULP()).map(f->f.build()).orElse(null);
			this.nSPT = ofNullable(builder.getNSPT()).map(f->f.build()).orElse(null);
			this.rCVP = ofNullable(builder.getRCVP()).map(f->f.build()).orElse(null);
			this.cBRD = ofNullable(builder.getCBRD()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("PULP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PULP")
		public AnnaDsbEmpty getPULP() {
			return pULP;
		}
		
		@Override
		@RosettaAttribute("NSPT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NSPT")
		public AnnaDsbEmpty getNSPT() {
			return nSPT;
		}
		
		@Override
		@RosettaAttribute("RCVP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("RCVP")
		public AnnaDsbEmpty getRCVP() {
			return rCVP;
		}
		
		@Override
		@RosettaAttribute("CBRD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CBRD")
		public AnnaDsbEmpty getCBRD() {
			return cBRD;
		}
		
		@Override
		public AnnaDsbPAPR build() {
			return this;
		}
		
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder toBuilder() {
			AnnaDsbPAPR.AnnaDsbPAPRBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbPAPR.AnnaDsbPAPRBuilder builder) {
			ofNullable(getPULP()).ifPresent(builder::setPULP);
			ofNullable(getNSPT()).ifPresent(builder::setNSPT);
			ofNullable(getRCVP()).ifPresent(builder::setRCVP);
			ofNullable(getCBRD()).ifPresent(builder::setCBRD);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbPAPR _that = getType().cast(o);
		
			if (!Objects.equals(pULP, _that.getPULP())) return false;
			if (!Objects.equals(nSPT, _that.getNSPT())) return false;
			if (!Objects.equals(rCVP, _that.getRCVP())) return false;
			if (!Objects.equals(cBRD, _that.getCBRD())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pULP != null ? pULP.hashCode() : 0);
			_result = 31 * _result + (nSPT != null ? nSPT.hashCode() : 0);
			_result = 31 * _result + (rCVP != null ? rCVP.hashCode() : 0);
			_result = 31 * _result + (cBRD != null ? cBRD.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbPAPR {" +
				"PULP=" + this.pULP + ", " +
				"NSPT=" + this.nSPT + ", " +
				"RCVP=" + this.rCVP + ", " +
				"CBRD=" + this.cBRD +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbPAPR  ***********************/
	class AnnaDsbPAPRBuilderImpl implements AnnaDsbPAPR.AnnaDsbPAPRBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder pULP;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder nSPT;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder rCVP;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder cBRD;
		
		@Override
		@RosettaAttribute("PULP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PULP")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getPULP() {
			return pULP;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreatePULP() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (pULP!=null) {
				result = pULP;
			}
			else {
				result = pULP = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("NSPT")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NSPT")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getNSPT() {
			return nSPT;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateNSPT() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (nSPT!=null) {
				result = nSPT;
			}
			else {
				result = nSPT = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("RCVP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("RCVP")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getRCVP() {
			return rCVP;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateRCVP() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (rCVP!=null) {
				result = rCVP;
			}
			else {
				result = rCVP = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("CBRD")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CBRD")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getCBRD() {
			return cBRD;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCBRD() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (cBRD!=null) {
				result = cBRD;
			}
			else {
				result = cBRD = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("PULP")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("PULP")
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder setPULP(AnnaDsbEmpty _pULP) {
			this.pULP = _pULP == null ? null : _pULP.toBuilder();
			return this;
		}
		
		@RosettaAttribute("NSPT")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NSPT")
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder setNSPT(AnnaDsbEmpty _nSPT) {
			this.nSPT = _nSPT == null ? null : _nSPT.toBuilder();
			return this;
		}
		
		@RosettaAttribute("RCVP")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("RCVP")
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder setRCVP(AnnaDsbEmpty _rCVP) {
			this.rCVP = _rCVP == null ? null : _rCVP.toBuilder();
			return this;
		}
		
		@RosettaAttribute("CBRD")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CBRD")
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder setCBRD(AnnaDsbEmpty _cBRD) {
			this.cBRD = _cBRD == null ? null : _cBRD.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbPAPR build() {
			return new AnnaDsbPAPR.AnnaDsbPAPRImpl(this);
		}
		
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder prune() {
			if (pULP!=null && !pULP.prune().hasData()) pULP = null;
			if (nSPT!=null && !nSPT.prune().hasData()) nSPT = null;
			if (rCVP!=null && !rCVP.prune().hasData()) rCVP = null;
			if (cBRD!=null && !cBRD.prune().hasData()) cBRD = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPULP()!=null && getPULP().hasData()) return true;
			if (getNSPT()!=null && getNSPT().hasData()) return true;
			if (getRCVP()!=null && getRCVP().hasData()) return true;
			if (getCBRD()!=null && getCBRD().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbPAPR.AnnaDsbPAPRBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbPAPR.AnnaDsbPAPRBuilder o = (AnnaDsbPAPR.AnnaDsbPAPRBuilder) other;
			
			merger.mergeRosetta(getPULP(), o.getPULP(), this::setPULP);
			merger.mergeRosetta(getNSPT(), o.getNSPT(), this::setNSPT);
			merger.mergeRosetta(getRCVP(), o.getRCVP(), this::setRCVP);
			merger.mergeRosetta(getCBRD(), o.getCBRD(), this::setCBRD);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbPAPR _that = getType().cast(o);
		
			if (!Objects.equals(pULP, _that.getPULP())) return false;
			if (!Objects.equals(nSPT, _that.getNSPT())) return false;
			if (!Objects.equals(rCVP, _that.getRCVP())) return false;
			if (!Objects.equals(cBRD, _that.getCBRD())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (pULP != null ? pULP.hashCode() : 0);
			_result = 31 * _result + (nSPT != null ? nSPT.hashCode() : 0);
			_result = 31 * _result + (rCVP != null ? rCVP.hashCode() : 0);
			_result = 31 * _result + (cBRD != null ? cBRD.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbPAPRBuilder {" +
				"PULP=" + this.pULP + ", " +
				"NSPT=" + this.nSPT + ", " +
				"RCVP=" + this.rCVP + ", " +
				"CBRD=" + this.cBRD +
			'}';
		}
	}
}
