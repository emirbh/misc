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
import drr.standards.iosco.upi.meta.AnnaDsbFRGTMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbFRGT", builder=AnnaDsbFRGT.AnnaDsbFRGTBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbFRGT", model="drr", builder=AnnaDsbFRGT.AnnaDsbFRGTBuilderImpl.class, version="7.7.0")
public interface AnnaDsbFRGT extends RosettaModelObject {

	AnnaDsbFRGTMeta metaData = new AnnaDsbFRGTMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbEmpty getCSHP();
	AnnaDsbAdditionalSubProduct getWETF();
	AnnaDsbAdditionalSubProduct getDRYF();

	/*********************** Build Methods  ***********************/
	AnnaDsbFRGT build();
	
	AnnaDsbFRGT.AnnaDsbFRGTBuilder toBuilder();
	
	static AnnaDsbFRGT.AnnaDsbFRGTBuilder builder() {
		return new AnnaDsbFRGT.AnnaDsbFRGTBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbFRGT> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbFRGT> getType() {
		return AnnaDsbFRGT.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("CSHP"), processor, AnnaDsbEmpty.class, getCSHP());
		processRosetta(path.newSubPath("WETF"), processor, AnnaDsbAdditionalSubProduct.class, getWETF());
		processRosetta(path.newSubPath("DRYF"), processor, AnnaDsbAdditionalSubProduct.class, getDRYF());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbFRGTBuilder extends AnnaDsbFRGT, RosettaModelObjectBuilder {
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCSHP();
		@Override
		AnnaDsbEmpty.AnnaDsbEmptyBuilder getCSHP();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateWETF();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getWETF();
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateDRYF();
		@Override
		AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getDRYF();
		AnnaDsbFRGT.AnnaDsbFRGTBuilder setCSHP(AnnaDsbEmpty CSHP);
		AnnaDsbFRGT.AnnaDsbFRGTBuilder setWETF(AnnaDsbAdditionalSubProduct WETF);
		AnnaDsbFRGT.AnnaDsbFRGTBuilder setDRYF(AnnaDsbAdditionalSubProduct DRYF);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("CSHP"), processor, AnnaDsbEmpty.AnnaDsbEmptyBuilder.class, getCSHP());
			processRosetta(path.newSubPath("WETF"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getWETF());
			processRosetta(path.newSubPath("DRYF"), processor, AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder.class, getDRYF());
		}
		

		AnnaDsbFRGT.AnnaDsbFRGTBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbFRGT  ***********************/
	class AnnaDsbFRGTImpl implements AnnaDsbFRGT {
		private final AnnaDsbEmpty cSHP;
		private final AnnaDsbAdditionalSubProduct wETF;
		private final AnnaDsbAdditionalSubProduct dRYF;
		
		protected AnnaDsbFRGTImpl(AnnaDsbFRGT.AnnaDsbFRGTBuilder builder) {
			this.cSHP = ofNullable(builder.getCSHP()).map(f->f.build()).orElse(null);
			this.wETF = ofNullable(builder.getWETF()).map(f->f.build()).orElse(null);
			this.dRYF = ofNullable(builder.getDRYF()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("CSHP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CSHP")
		public AnnaDsbEmpty getCSHP() {
			return cSHP;
		}
		
		@Override
		@RosettaAttribute("WETF")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("WETF")
		public AnnaDsbAdditionalSubProduct getWETF() {
			return wETF;
		}
		
		@Override
		@RosettaAttribute("DRYF")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DRYF")
		public AnnaDsbAdditionalSubProduct getDRYF() {
			return dRYF;
		}
		
		@Override
		public AnnaDsbFRGT build() {
			return this;
		}
		
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder toBuilder() {
			AnnaDsbFRGT.AnnaDsbFRGTBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbFRGT.AnnaDsbFRGTBuilder builder) {
			ofNullable(getCSHP()).ifPresent(builder::setCSHP);
			ofNullable(getWETF()).ifPresent(builder::setWETF);
			ofNullable(getDRYF()).ifPresent(builder::setDRYF);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbFRGT _that = getType().cast(o);
		
			if (!Objects.equals(cSHP, _that.getCSHP())) return false;
			if (!Objects.equals(wETF, _that.getWETF())) return false;
			if (!Objects.equals(dRYF, _that.getDRYF())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cSHP != null ? cSHP.hashCode() : 0);
			_result = 31 * _result + (wETF != null ? wETF.hashCode() : 0);
			_result = 31 * _result + (dRYF != null ? dRYF.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbFRGT {" +
				"CSHP=" + this.cSHP + ", " +
				"WETF=" + this.wETF + ", " +
				"DRYF=" + this.dRYF +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbFRGT  ***********************/
	class AnnaDsbFRGTBuilderImpl implements AnnaDsbFRGT.AnnaDsbFRGTBuilder {
	
		protected AnnaDsbEmpty.AnnaDsbEmptyBuilder cSHP;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder wETF;
		protected AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder dRYF;
		
		@Override
		@RosettaAttribute("CSHP")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("CSHP")
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getCSHP() {
			return cSHP;
		}
		
		@Override
		public AnnaDsbEmpty.AnnaDsbEmptyBuilder getOrCreateCSHP() {
			AnnaDsbEmpty.AnnaDsbEmptyBuilder result;
			if (cSHP!=null) {
				result = cSHP;
			}
			else {
				result = cSHP = AnnaDsbEmpty.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("WETF")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("WETF")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getWETF() {
			return wETF;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateWETF() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (wETF!=null) {
				result = wETF;
			}
			else {
				result = wETF = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("DRYF")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("DRYF")
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getDRYF() {
			return dRYF;
		}
		
		@Override
		public AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder getOrCreateDRYF() {
			AnnaDsbAdditionalSubProduct.AnnaDsbAdditionalSubProductBuilder result;
			if (dRYF!=null) {
				result = dRYF;
			}
			else {
				result = dRYF = AnnaDsbAdditionalSubProduct.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("CSHP")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("CSHP")
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder setCSHP(AnnaDsbEmpty _cSHP) {
			this.cSHP = _cSHP == null ? null : _cSHP.toBuilder();
			return this;
		}
		
		@RosettaAttribute("WETF")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("WETF")
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder setWETF(AnnaDsbAdditionalSubProduct _wETF) {
			this.wETF = _wETF == null ? null : _wETF.toBuilder();
			return this;
		}
		
		@RosettaAttribute("DRYF")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("DRYF")
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder setDRYF(AnnaDsbAdditionalSubProduct _dRYF) {
			this.dRYF = _dRYF == null ? null : _dRYF.toBuilder();
			return this;
		}
		
		@Override
		public AnnaDsbFRGT build() {
			return new AnnaDsbFRGT.AnnaDsbFRGTImpl(this);
		}
		
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder prune() {
			if (cSHP!=null && !cSHP.prune().hasData()) cSHP = null;
			if (wETF!=null && !wETF.prune().hasData()) wETF = null;
			if (dRYF!=null && !dRYF.prune().hasData()) dRYF = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCSHP()!=null && getCSHP().hasData()) return true;
			if (getWETF()!=null && getWETF().hasData()) return true;
			if (getDRYF()!=null && getDRYF().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbFRGT.AnnaDsbFRGTBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbFRGT.AnnaDsbFRGTBuilder o = (AnnaDsbFRGT.AnnaDsbFRGTBuilder) other;
			
			merger.mergeRosetta(getCSHP(), o.getCSHP(), this::setCSHP);
			merger.mergeRosetta(getWETF(), o.getWETF(), this::setWETF);
			merger.mergeRosetta(getDRYF(), o.getDRYF(), this::setDRYF);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbFRGT _that = getType().cast(o);
		
			if (!Objects.equals(cSHP, _that.getCSHP())) return false;
			if (!Objects.equals(wETF, _that.getWETF())) return false;
			if (!Objects.equals(dRYF, _that.getDRYF())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cSHP != null ? cSHP.hashCode() : 0);
			_result = 31 * _result + (wETF != null ? wETF.hashCode() : 0);
			_result = 31 * _result + (dRYF != null ? dRYF.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbFRGTBuilder {" +
				"CSHP=" + this.cSHP + ", " +
				"WETF=" + this.wETF + ", " +
				"DRYF=" + this.dRYF +
			'}';
		}
	}
}
