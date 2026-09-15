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
import drr.standards.iosco.upi.meta.AnnaDsbENVRMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbENVR", builder=AnnaDsbENVR.AnnaDsbENVRBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbENVR", model="drr", builder=AnnaDsbENVR.AnnaDsbENVRBuilderImpl.class, version="7.7.0")
public interface AnnaDsbENVR extends RosettaModelObject {

	AnnaDsbENVRMeta metaData = new AnnaDsbENVRMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getCRBR();
	AnnaDsbAdditionalSubProduct getEMIS();
	AnnaDsbEmpty getWTHR();

	/*********************** Build Methods  ***********************/
	AnnaDsbENVR build();
	
	AnnaDsbENVR.AnnaDsbENVRBuilder toBuilder();
	
	static AnnaDsbENVR.AnnaDsbENVRBuilder builder() {
		return new AnnaDsbENVR.AnnaDsbENVRBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbENVR> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbENVR> getType() {
		return AnnaDsbENVR.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("CRBR"), processor, AnnaDsbEmpty.class, getCRBR());
		processRosetta(path.newSubPath("EMIS"), processor, AnnaDsbAdditionalSubProduct.class, getEMIS());
		processRosetta(path.newSubPath("WTHR"), processor, AnnaDsbEmpty.class, getWTHR());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbENVRBuilder extends AnnaDsbENVR, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCRBR();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getCRBR();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateEMIS();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getEMIS();
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateWTHR();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getWTHR();
		AnnaDsbENVR.AnnaDsbENVRBuilder setCRBR(AnnaDsbEmpty CRBR);
		AnnaDsbENVR.AnnaDsbENVRBuilder setEMIS(AnnaDsbAdditionalSubProduct EMIS);
		AnnaDsbENVR.AnnaDsbENVRBuilder setWTHR(AnnaDsbEmpty WTHR);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("CRBR"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getCRBR());
			processRosetta(path.newSubPath("EMIS"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getEMIS());
			processRosetta(path.newSubPath("WTHR"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getWTHR());
		}
		

		AnnaDsbENVR.AnnaDsbENVRBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbENVR  ***********************/
	class AnnaDsbENVRImpl implements AnnaDsbENVR {
		private final AnnaDsbEmpty cRBR;
		private final AnnaDsbAdditionalSubProduct eMIS;
		private final AnnaDsbEmpty wTHR;
		
		protected AnnaDsbENVRImpl(AnnaDsbENVR.AnnaDsbENVRBuilder builder) {
			this.cRBR = ofNullable(builder.getCRBR()).map(f->f.build()).orElse(null);
			this.eMIS = ofNullable(builder.getEMIS()).map(f->f.build()).orElse(null);
			this.wTHR = ofNullable(builder.getWTHR()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("CRBR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CRBR")
		public AnnaDsbEmpty getCRBR() {
			return cRBR;
		}
		
		@Override
		@RosettaAttribute("EMIS")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("EMIS")
		public AnnaDsbAdditionalSubProduct getEMIS() {
			return eMIS;
		}
		
		@Override
		@RosettaAttribute("WTHR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("WTHR")
		public AnnaDsbEmpty getWTHR() {
			return wTHR;
		}
		
		@Override
		public AnnaDsbENVR build() {
			return this;
		}
		
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder toBuilder() {
			AnnaDsbENVR.AnnaDsbENVRBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbENVR.AnnaDsbENVRBuilder builder) {
			ofNullable(getCRBR()).ifPresent(builder::setCRBR);
			ofNullable(getEMIS()).ifPresent(builder::setEMIS);
			ofNullable(getWTHR()).ifPresent(builder::setWTHR);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbENVR _that = getType().cast(o);
		
			if (!Objects.equals(cRBR, _that.getCRBR())) return false;
			if (!Objects.equals(eMIS, _that.getEMIS())) return false;
			if (!Objects.equals(wTHR, _that.getWTHR())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cRBR != null ? cRBR.hashCode() : 0);
			_result = 31 * _result + (eMIS != null ? eMIS.hashCode() : 0);
			_result = 31 * _result + (wTHR != null ? wTHR.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbENVR {" +
				"CRBR=" + this.cRBR + ", " +
				"EMIS=" + this.eMIS + ", " +
				"WTHR=" + this.wTHR +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbENVR  ***********************/
	class AnnaDsbENVRBuilderImpl implements AnnaDsbENVR.AnnaDsbENVRBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder cRBR;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder eMIS;
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder wTHR;
		
		@Override
		@RosettaAttribute("CRBR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CRBR")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getCRBR() {
			return cRBR;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCRBR() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (cRBR!=null) {
				result = cRBR;
			}
			else {
				result = cRBR = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("EMIS")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("EMIS")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getEMIS() {
			return eMIS;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateEMIS() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (eMIS!=null) {
				result = eMIS;
			}
			else {
				result = eMIS = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("WTHR")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("WTHR")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getWTHR() {
			return wTHR;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateWTHR() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (wTHR!=null) {
				result = wTHR;
			}
			else {
				result = wTHR = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("CRBR")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CRBR")
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder setCRBR(AnnaDsbEmpty _cRBR) {
			this.cRBR = _cRBR == null ? null : _cRBR.toBuilder();
			return this;
		}
		
		@RosettaAttribute("EMIS")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("EMIS")
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder setEMIS(AnnaDsbAdditionalSubProduct _eMIS) {
			this.eMIS = _eMIS == null ? null : _eMIS.toBuilder();
			return this;
		}
		
		@RosettaAttribute("WTHR")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("WTHR")
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder setWTHR(AnnaDsbEmpty _wTHR) {
			this.wTHR = _wTHR == null ? null : _wTHR.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbENVR build() {
			return new AnnaDsbENVR.AnnaDsbENVRImpl(this);
		}
		
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder prune() {
			if (cRBR!=null && !cRBR.prune().hasData()) cRBR = null;
			if (eMIS!=null && !eMIS.prune().hasData()) eMIS = null;
			if (wTHR!=null && !wTHR.prune().hasData()) wTHR = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCRBR()!=null && getCRBR().hasData()) return true;
			if (getEMIS()!=null && getEMIS().hasData()) return true;
			if (getWTHR()!=null && getWTHR().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbENVR.AnnaDsbENVRBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbENVR.AnnaDsbENVRBuilder o = (AnnaDsbENVR.AnnaDsbENVRBuilder) other;
			
			merger.mergeRosetta(getCRBR(), o.getCRBR(), this::setCRBR);
			merger.mergeRosetta(getEMIS(), o.getEMIS(), this::setEMIS);
			merger.mergeRosetta(getWTHR(), o.getWTHR(), this::setWTHR);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbENVR _that = getType().cast(o);
		
			if (!Objects.equals(cRBR, _that.getCRBR())) return false;
			if (!Objects.equals(eMIS, _that.getEMIS())) return false;
			if (!Objects.equals(wTHR, _that.getWTHR())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cRBR != null ? cRBR.hashCode() : 0);
			_result = 31 * _result + (eMIS != null ? eMIS.hashCode() : 0);
			_result = 31 * _result + (wTHR != null ? wTHR.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbENVRBuilder {" +
				"CRBR=" + this.cRBR + ", " +
				"EMIS=" + this.eMIS + ", " +
				"WTHR=" + this.wTHR +
			'}';
		}
	}
}
