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
import drr.standards.iosco.upi.meta.AnnaDsbOTHCMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbOTHC", builder=AnnaDsbOTHC.AnnaDsbOTHCBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbOTHC", model="drr", builder=AnnaDsbOTHC.AnnaDsbOTHCBuilderImpl.class, version="7.7.0")
public interface AnnaDsbOTHC extends RosettaModelObject {

	AnnaDsbOTHCMeta metaData = new AnnaDsbOTHCMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getDLVR();
	AnnaDsbEmpty getNDLV();

	/*********************** Build Methods  ***********************/
	AnnaDsbOTHC build();
	
	AnnaDsbOTHC.AnnaDsbOTHCBuilder toBuilder();
	
	static AnnaDsbOTHC.AnnaDsbOTHCBuilder builder() {
		return new AnnaDsbOTHC.AnnaDsbOTHCBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbOTHC> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbOTHC> getType() {
		return AnnaDsbOTHC.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("DLVR"), processor, AnnaDsbEmpty.class, getDLVR());
		processRosetta(path.newSubPath("NDLV"), processor, AnnaDsbEmpty.class, getNDLV());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbOTHCBuilder extends AnnaDsbOTHC, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDLVR();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getDLVR();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateNDLV();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getNDLV();
		AnnaDsbOTHC.AnnaDsbOTHCBuilder setDLVR(AnnaDsbEmpty DLVR);
		AnnaDsbOTHC.AnnaDsbOTHCBuilder setNDLV(AnnaDsbEmpty NDLV);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("DLVR"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getDLVR());
			processRosetta(path.newSubPath("NDLV"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getNDLV());
		}
		

		AnnaDsbOTHC.AnnaDsbOTHCBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbOTHC  ***********************/
	class AnnaDsbOTHCImpl implements AnnaDsbOTHC {
		private final AnnaDsbEmpty dLVR;
		private final AnnaDsbEmpty nDLV;
		
		protected AnnaDsbOTHCImpl(AnnaDsbOTHC.AnnaDsbOTHCBuilder builder) {
			this.dLVR = ofNullable(builder.getDLVR()).map(f->f.build()).orElse(null);
			this.nDLV = ofNullable(builder.getNDLV()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("DLVR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DLVR")
		public AnnaDsbEmpty getDLVR() {
			return dLVR;
		}
		
		@Override
		@RosettaAttribute("NDLV")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NDLV")
		public AnnaDsbEmpty getNDLV() {
			return nDLV;
		}
		
		@Override
		public AnnaDsbOTHC build() {
			return this;
		}
		
		@Override
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder toBuilder() {
			AnnaDsbOTHC.AnnaDsbOTHCBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbOTHC.AnnaDsbOTHCBuilder builder) {
			ofNullable(getDLVR()).ifPresent(builder::setDLVR);
			ofNullable(getNDLV()).ifPresent(builder::setNDLV);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOTHC _that = getType().cast(o);
		
			if (!Objects.equals(dLVR, _that.getDLVR())) return false;
			if (!Objects.equals(nDLV, _that.getNDLV())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dLVR != null ? dLVR.hashCode() : 0);
			_result = 31 * _result + (nDLV != null ? nDLV.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOTHC {" +
				"DLVR=" + this.dLVR + ", " +
				"NDLV=" + this.nDLV +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbOTHC  ***********************/
	class AnnaDsbOTHCBuilderImpl implements AnnaDsbOTHC.AnnaDsbOTHCBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder dLVR;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder nDLV;
		
		@Override
		@RosettaAttribute("DLVR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DLVR")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getDLVR() {
			return dLVR;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateDLVR() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (dLVR!=null) {
				result = dLVR;
			}
			else {
				result = dLVR = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("NDLV")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("NDLV")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getNDLV() {
			return nDLV;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateNDLV() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (nDLV!=null) {
				result = nDLV;
			}
			else {
				result = nDLV = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("DLVR")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DLVR")
		@Override
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder setDLVR(AnnaDsbEmpty _dLVR) {
			this.dLVR = _dLVR == null ? null : _dLVR.toBuilder();
			return this;
		}
		
		@RosettaAttribute("NDLV")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("NDLV")
		@Override
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder setNDLV(AnnaDsbEmpty _nDLV) {
			this.nDLV = _nDLV == null ? null : _nDLV.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbOTHC build() {
			return new AnnaDsbOTHC.AnnaDsbOTHCImpl(this);
		}
		
		@Override
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder prune() {
			if (dLVR!=null && !dLVR.prune().hasData()) dLVR = null;
			if (nDLV!=null && !nDLV.prune().hasData()) nDLV = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDLVR()!=null && getDLVR().hasData()) return true;
			if (getNDLV()!=null && getNDLV().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbOTHC.AnnaDsbOTHCBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbOTHC.AnnaDsbOTHCBuilder o = (AnnaDsbOTHC.AnnaDsbOTHCBuilder) other;
			
			merger.mergeRosetta(getDLVR(), o.getDLVR(), this::setDLVR);
			merger.mergeRosetta(getNDLV(), o.getNDLV(), this::setNDLV);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbOTHC _that = getType().cast(o);
		
			if (!Objects.equals(dLVR, _that.getDLVR())) return false;
			if (!Objects.equals(nDLV, _that.getNDLV())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dLVR != null ? dLVR.hashCode() : 0);
			_result = 31 * _result + (nDLV != null ? nDLV.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbOTHCBuilder {" +
				"DLVR=" + this.dLVR + ", " +
				"NDLV=" + this.nDLV +
			'}';
		}
	}
}
