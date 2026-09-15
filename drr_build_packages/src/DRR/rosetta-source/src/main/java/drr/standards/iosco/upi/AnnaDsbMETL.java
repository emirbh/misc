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
import drr.standards.iosco.upi.meta.AnnaDsbMETLMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbMETL", builder=AnnaDsbMETL.AnnaDsbMETLBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbMETL", model="drr", builder=AnnaDsbMETL.AnnaDsbMETLBuilderImpl.class, version="7.7.0")
public interface AnnaDsbMETL extends RosettaModelObject {

	AnnaDsbMETLMeta metaData = new AnnaDsbMETLMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbAdditionalSubProduct getNPRM();
	AnnaDsbAdditionalSubProduct getPRME();

	/*********************** Build Methods  ***********************/
	AnnaDsbMETL build();
	
	AnnaDsbMETL.AnnaDsbMETLBuilder toBuilder();
	
	static AnnaDsbMETL.AnnaDsbMETLBuilder builder() {
		return new AnnaDsbMETL.AnnaDsbMETLBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbMETL> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbMETL> getType() {
		return AnnaDsbMETL.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("NPRM"), processor, AnnaDsbAdditionalSubProduct.class, getNPRM());
		processRosetta(path.newSubPath("PRME"), processor, AnnaDsbAdditionalSubProduct.class, getPRME());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbMETLBuilder extends AnnaDsbMETL, RosettaModelObjectBuilder {
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateNPRM();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getNPRM();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreatePRME();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getPRME();
		AnnaDsbMETL.AnnaDsbMETLBuilder setNPRM(AnnaDsbAdditionalSubProduct NPRM);
		AnnaDsbMETL.AnnaDsbMETLBuilder setPRME(AnnaDsbAdditionalSubProduct PRME);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("NPRM"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getNPRM());
			processRosetta(path.newSubPath("PRME"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getPRME());
		}
		

		AnnaDsbMETL.AnnaDsbMETLBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbMETL  ***********************/
	class AnnaDsbMETLImpl implements AnnaDsbMETL {
		private final AnnaDsbAdditionalSubProduct nPRM;
		private final AnnaDsbAdditionalSubProduct pRME;
		
		protected AnnaDsbMETLImpl(AnnaDsbMETL.AnnaDsbMETLBuilder builder) {
			this.nPRM = ofNullable(builder.getNPRM()).map(f->f.build()).orElse(null);
			this.pRME = ofNullable(builder.getPRME()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("NPRM")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NPRM")
		public AnnaDsbAdditionalSubProduct getNPRM() {
			return nPRM;
		}
		
		@Override
		@RosettaAttribute("PRME")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PRME")
		public AnnaDsbAdditionalSubProduct getPRME() {
			return pRME;
		}
		
		@Override
		public AnnaDsbMETL build() {
			return this;
		}
		
		@Override
		public AnnaDsbMETL.AnnaDsbMETLBuilder toBuilder() {
			AnnaDsbMETL.AnnaDsbMETLBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbMETL.AnnaDsbMETLBuilder builder) {
			ofNullable(getNPRM()).ifPresent(builder::setNPRM);
			ofNullable(getPRME()).ifPresent(builder::setPRME);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbMETL _that = getType().cast(o);
		
			if (!Objects.equals(nPRM, _that.getNPRM())) return false;
			if (!Objects.equals(pRME, _that.getPRME())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nPRM != null ? nPRM.hashCode() : 0);
			_result = 31 * _result + (pRME != null ? pRME.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbMETL {" +
				"NPRM=" + this.nPRM + ", " +
				"PRME=" + this.pRME +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbMETL  ***********************/
	class AnnaDsbMETLBuilderImpl implements AnnaDsbMETL.AnnaDsbMETLBuilder {
	
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder nPRM;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder pRME;
		
		@Override
		@RosettaAttribute("NPRM")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NPRM")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getNPRM() {
			return nPRM;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateNPRM() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (nPRM!=null) {
				result = nPRM;
			}
			else {
				result = nPRM = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("PRME")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("PRME")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getPRME() {
			return pRME;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreatePRME() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (pRME!=null) {
				result = pRME;
			}
			else {
				result = pRME = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("NPRM")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NPRM")
		@Override
		public AnnaDsbMETL.AnnaDsbMETLBuilder setNPRM(AnnaDsbAdditionalSubProduct _nPRM) {
			this.nPRM = _nPRM == null ? null : _nPRM.toBuilder();
			return this;
		}
		
		@RosettaAttribute("PRME")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("PRME")
		@Override
		public AnnaDsbMETL.AnnaDsbMETLBuilder setPRME(AnnaDsbAdditionalSubProduct _pRME) {
			this.pRME = _pRME == null ? null : _pRME.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbMETL build() {
			return new AnnaDsbMETL.AnnaDsbMETLImpl(this);
		}
		
		@Override
		public AnnaDsbMETL.AnnaDsbMETLBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbMETL.AnnaDsbMETLBuilder prune() {
			if (nPRM!=null && !nPRM.prune().hasData()) nPRM = null;
			if (pRME!=null && !pRME.prune().hasData()) pRME = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNPRM()!=null && getNPRM().hasData()) return true;
			if (getPRME()!=null && getPRME().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbMETL.AnnaDsbMETLBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbMETL.AnnaDsbMETLBuilder o = (AnnaDsbMETL.AnnaDsbMETLBuilder) other;
			
			merger.mergeRosetta(getNPRM(), o.getNPRM(), this::setNPRM);
			merger.mergeRosetta(getPRME(), o.getPRME(), this::setPRME);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbMETL _that = getType().cast(o);
		
			if (!Objects.equals(nPRM, _that.getNPRM())) return false;
			if (!Objects.equals(pRME, _that.getPRME())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (nPRM != null ? nPRM.hashCode() : 0);
			_result = 31 * _result + (pRME != null ? pRME.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbMETLBuilder {" +
				"NPRM=" + this.nPRM + ", " +
				"PRME=" + this.pRME +
			'}';
		}
	}
}
