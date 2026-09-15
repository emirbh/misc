package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.AssetClassCommodityEnergy3Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is energy.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityEnergy3Choice__1", builder=AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityEnergy3Choice__1", model="iso20022", builder=AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityEnergy3Choice__1 extends RosettaModelObject {

	AssetClassCommodityEnergy3Choice__1Meta metaData = new AssetClassCommodityEnergy3Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Definition of Electricity energy commodity derivative.
	 */
	EnergyCommodityElectricity2__1 getElctrcty();
	/**
	 * Definition of Natural Gas energy commodity derivative.
	 */
	EnergyCommodityNaturalGas3__1 getNtrlGas();
	/**
	 * Definition of Oil energy commodity derivative.
	 */
	EnergyCommodityOil3__1 getOil();
	/**
	 * Definition of Coal energy commodity derivative.
	 */
	EnergyCommodityCoal2__1 getCoal();
	/**
	 * Inter energy commodity derivative.
	 */
	EnergyCommodityInterEnergy2__1 getIntrNrgy();
	/**
	 * Renewable energy commodity derivative.
	 */
	EnergyCommodityRenewableEnergy2__1 getRnwblNrgy();
	/**
	 * Light end energy commodity derivative.
	 */
	EnergyCommodityLightEnd2__1 getLghtEnd();
	/**
	 * Distillates energy commodity derivative.
	 */
	EnergyCommodityDistillates2__1 getDstllts();
	/**
	 * Other energy commodity derivative.
	 */
	EnergyCommodityOther2__1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityEnergy3Choice__1 build();
	
	AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder toBuilder();
	
	static AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder builder() {
		return new AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityEnergy3Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityEnergy3Choice__1> getType() {
		return AssetClassCommodityEnergy3Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("elctrcty"), processor, EnergyCommodityElectricity2__1.class, getElctrcty());
		processRosetta(path.newSubPath("ntrlGas"), processor, EnergyCommodityNaturalGas3__1.class, getNtrlGas());
		processRosetta(path.newSubPath("oil"), processor, EnergyCommodityOil3__1.class, getOil());
		processRosetta(path.newSubPath("coal"), processor, EnergyCommodityCoal2__1.class, getCoal());
		processRosetta(path.newSubPath("intrNrgy"), processor, EnergyCommodityInterEnergy2__1.class, getIntrNrgy());
		processRosetta(path.newSubPath("rnwblNrgy"), processor, EnergyCommodityRenewableEnergy2__1.class, getRnwblNrgy());
		processRosetta(path.newSubPath("lghtEnd"), processor, EnergyCommodityLightEnd2__1.class, getLghtEnd());
		processRosetta(path.newSubPath("dstllts"), processor, EnergyCommodityDistillates2__1.class, getDstllts());
		processRosetta(path.newSubPath("othr"), processor, EnergyCommodityOther2__1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityEnergy3Choice__1Builder extends AssetClassCommodityEnergy3Choice__1, RosettaModelObjectBuilder {
		EnergyCommodityElectricity2__1.EnergyCommodityElectricity2__1Builder getOrCreateElctrcty();
		@Override
		EnergyCommodityElectricity2__1.EnergyCommodityElectricity2__1Builder getElctrcty();
		EnergyCommodityNaturalGas3__1.EnergyCommodityNaturalGas3__1Builder getOrCreateNtrlGas();
		@Override
		EnergyCommodityNaturalGas3__1.EnergyCommodityNaturalGas3__1Builder getNtrlGas();
		EnergyCommodityOil3__1.EnergyCommodityOil3__1Builder getOrCreateOil();
		@Override
		EnergyCommodityOil3__1.EnergyCommodityOil3__1Builder getOil();
		EnergyCommodityCoal2__1.EnergyCommodityCoal2__1Builder getOrCreateCoal();
		@Override
		EnergyCommodityCoal2__1.EnergyCommodityCoal2__1Builder getCoal();
		EnergyCommodityInterEnergy2__1.EnergyCommodityInterEnergy2__1Builder getOrCreateIntrNrgy();
		@Override
		EnergyCommodityInterEnergy2__1.EnergyCommodityInterEnergy2__1Builder getIntrNrgy();
		EnergyCommodityRenewableEnergy2__1.EnergyCommodityRenewableEnergy2__1Builder getOrCreateRnwblNrgy();
		@Override
		EnergyCommodityRenewableEnergy2__1.EnergyCommodityRenewableEnergy2__1Builder getRnwblNrgy();
		EnergyCommodityLightEnd2__1.EnergyCommodityLightEnd2__1Builder getOrCreateLghtEnd();
		@Override
		EnergyCommodityLightEnd2__1.EnergyCommodityLightEnd2__1Builder getLghtEnd();
		EnergyCommodityDistillates2__1.EnergyCommodityDistillates2__1Builder getOrCreateDstllts();
		@Override
		EnergyCommodityDistillates2__1.EnergyCommodityDistillates2__1Builder getDstllts();
		EnergyCommodityOther2__1.EnergyCommodityOther2__1Builder getOrCreateOthr();
		@Override
		EnergyCommodityOther2__1.EnergyCommodityOther2__1Builder getOthr();
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setElctrcty(EnergyCommodityElectricity2__1 elctrcty);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setNtrlGas(EnergyCommodityNaturalGas3__1 ntrlGas);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setOil(EnergyCommodityOil3__1 oil);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setCoal(EnergyCommodityCoal2__1 coal);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setIntrNrgy(EnergyCommodityInterEnergy2__1 intrNrgy);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setRnwblNrgy(EnergyCommodityRenewableEnergy2__1 rnwblNrgy);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setLghtEnd(EnergyCommodityLightEnd2__1 lghtEnd);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setDstllts(EnergyCommodityDistillates2__1 dstllts);
		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setOthr(EnergyCommodityOther2__1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("elctrcty"), processor, EnergyCommodityElectricity2__1.EnergyCommodityElectricity2__1Builder.class, getElctrcty());
			processRosetta(path.newSubPath("ntrlGas"), processor, EnergyCommodityNaturalGas3__1.EnergyCommodityNaturalGas3__1Builder.class, getNtrlGas());
			processRosetta(path.newSubPath("oil"), processor, EnergyCommodityOil3__1.EnergyCommodityOil3__1Builder.class, getOil());
			processRosetta(path.newSubPath("coal"), processor, EnergyCommodityCoal2__1.EnergyCommodityCoal2__1Builder.class, getCoal());
			processRosetta(path.newSubPath("intrNrgy"), processor, EnergyCommodityInterEnergy2__1.EnergyCommodityInterEnergy2__1Builder.class, getIntrNrgy());
			processRosetta(path.newSubPath("rnwblNrgy"), processor, EnergyCommodityRenewableEnergy2__1.EnergyCommodityRenewableEnergy2__1Builder.class, getRnwblNrgy());
			processRosetta(path.newSubPath("lghtEnd"), processor, EnergyCommodityLightEnd2__1.EnergyCommodityLightEnd2__1Builder.class, getLghtEnd());
			processRosetta(path.newSubPath("dstllts"), processor, EnergyCommodityDistillates2__1.EnergyCommodityDistillates2__1Builder.class, getDstllts());
			processRosetta(path.newSubPath("othr"), processor, EnergyCommodityOther2__1.EnergyCommodityOther2__1Builder.class, getOthr());
		}
		

		AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityEnergy3Choice__1  ***********************/
	class AssetClassCommodityEnergy3Choice__1Impl implements AssetClassCommodityEnergy3Choice__1 {
		private final EnergyCommodityElectricity2__1 elctrcty;
		private final EnergyCommodityNaturalGas3__1 ntrlGas;
		private final EnergyCommodityOil3__1 oil;
		private final EnergyCommodityCoal2__1 coal;
		private final EnergyCommodityInterEnergy2__1 intrNrgy;
		private final EnergyCommodityRenewableEnergy2__1 rnwblNrgy;
		private final EnergyCommodityLightEnd2__1 lghtEnd;
		private final EnergyCommodityDistillates2__1 dstllts;
		private final EnergyCommodityOther2__1 othr;
		
		protected AssetClassCommodityEnergy3Choice__1Impl(AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder builder) {
			this.elctrcty = ofNullable(builder.getElctrcty()).map(f->f.build()).orElse(null);
			this.ntrlGas = ofNullable(builder.getNtrlGas()).map(f->f.build()).orElse(null);
			this.oil = ofNullable(builder.getOil()).map(f->f.build()).orElse(null);
			this.coal = ofNullable(builder.getCoal()).map(f->f.build()).orElse(null);
			this.intrNrgy = ofNullable(builder.getIntrNrgy()).map(f->f.build()).orElse(null);
			this.rnwblNrgy = ofNullable(builder.getRnwblNrgy()).map(f->f.build()).orElse(null);
			this.lghtEnd = ofNullable(builder.getLghtEnd()).map(f->f.build()).orElse(null);
			this.dstllts = ofNullable(builder.getDstllts()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("elctrcty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("elctrcty")
		public EnergyCommodityElectricity2__1 getElctrcty() {
			return elctrcty;
		}
		
		@Override
		@RosettaAttribute("ntrlGas")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrlGas")
		public EnergyCommodityNaturalGas3__1 getNtrlGas() {
			return ntrlGas;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oil")
		public EnergyCommodityOil3__1 getOil() {
			return oil;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coal")
		public EnergyCommodityCoal2__1 getCoal() {
			return coal;
		}
		
		@Override
		@RosettaAttribute("intrNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrNrgy")
		public EnergyCommodityInterEnergy2__1 getIntrNrgy() {
			return intrNrgy;
		}
		
		@Override
		@RosettaAttribute("rnwblNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rnwblNrgy")
		public EnergyCommodityRenewableEnergy2__1 getRnwblNrgy() {
			return rnwblNrgy;
		}
		
		@Override
		@RosettaAttribute("lghtEnd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lghtEnd")
		public EnergyCommodityLightEnd2__1 getLghtEnd() {
			return lghtEnd;
		}
		
		@Override
		@RosettaAttribute("dstllts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dstllts")
		public EnergyCommodityDistillates2__1 getDstllts() {
			return dstllts;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnergyCommodityOther2__1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder toBuilder() {
			AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder builder) {
			ofNullable(getElctrcty()).ifPresent(builder::setElctrcty);
			ofNullable(getNtrlGas()).ifPresent(builder::setNtrlGas);
			ofNullable(getOil()).ifPresent(builder::setOil);
			ofNullable(getCoal()).ifPresent(builder::setCoal);
			ofNullable(getIntrNrgy()).ifPresent(builder::setIntrNrgy);
			ofNullable(getRnwblNrgy()).ifPresent(builder::setRnwblNrgy);
			ofNullable(getLghtEnd()).ifPresent(builder::setLghtEnd);
			ofNullable(getDstllts()).ifPresent(builder::setDstllts);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityEnergy3Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(elctrcty, _that.getElctrcty())) return false;
			if (!Objects.equals(ntrlGas, _that.getNtrlGas())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(intrNrgy, _that.getIntrNrgy())) return false;
			if (!Objects.equals(rnwblNrgy, _that.getRnwblNrgy())) return false;
			if (!Objects.equals(lghtEnd, _that.getLghtEnd())) return false;
			if (!Objects.equals(dstllts, _that.getDstllts())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (elctrcty != null ? elctrcty.hashCode() : 0);
			_result = 31 * _result + (ntrlGas != null ? ntrlGas.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (intrNrgy != null ? intrNrgy.hashCode() : 0);
			_result = 31 * _result + (rnwblNrgy != null ? rnwblNrgy.hashCode() : 0);
			_result = 31 * _result + (lghtEnd != null ? lghtEnd.hashCode() : 0);
			_result = 31 * _result + (dstllts != null ? dstllts.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityEnergy3Choice__1 {" +
				"elctrcty=" + this.elctrcty + ", " +
				"ntrlGas=" + this.ntrlGas + ", " +
				"oil=" + this.oil + ", " +
				"coal=" + this.coal + ", " +
				"intrNrgy=" + this.intrNrgy + ", " +
				"rnwblNrgy=" + this.rnwblNrgy + ", " +
				"lghtEnd=" + this.lghtEnd + ", " +
				"dstllts=" + this.dstllts + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityEnergy3Choice__1  ***********************/
	class AssetClassCommodityEnergy3Choice__1BuilderImpl implements AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder {
	
		protected EnergyCommodityElectricity2__1.EnergyCommodityElectricity2__1Builder elctrcty;
		protected EnergyCommodityNaturalGas3__1.EnergyCommodityNaturalGas3__1Builder ntrlGas;
		protected EnergyCommodityOil3__1.EnergyCommodityOil3__1Builder oil;
		protected EnergyCommodityCoal2__1.EnergyCommodityCoal2__1Builder coal;
		protected EnergyCommodityInterEnergy2__1.EnergyCommodityInterEnergy2__1Builder intrNrgy;
		protected EnergyCommodityRenewableEnergy2__1.EnergyCommodityRenewableEnergy2__1Builder rnwblNrgy;
		protected EnergyCommodityLightEnd2__1.EnergyCommodityLightEnd2__1Builder lghtEnd;
		protected EnergyCommodityDistillates2__1.EnergyCommodityDistillates2__1Builder dstllts;
		protected EnergyCommodityOther2__1.EnergyCommodityOther2__1Builder othr;
		
		@Override
		@RosettaAttribute("elctrcty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("elctrcty")
		public EnergyCommodityElectricity2__1.EnergyCommodityElectricity2__1Builder getElctrcty() {
			return elctrcty;
		}
		
		@Override
		public EnergyCommodityElectricity2__1.EnergyCommodityElectricity2__1Builder getOrCreateElctrcty() {
			EnergyCommodityElectricity2__1.EnergyCommodityElectricity2__1Builder result;
			if (elctrcty!=null) {
				result = elctrcty;
			}
			else {
				result = elctrcty = EnergyCommodityElectricity2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntrlGas")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrlGas")
		public EnergyCommodityNaturalGas3__1.EnergyCommodityNaturalGas3__1Builder getNtrlGas() {
			return ntrlGas;
		}
		
		@Override
		public EnergyCommodityNaturalGas3__1.EnergyCommodityNaturalGas3__1Builder getOrCreateNtrlGas() {
			EnergyCommodityNaturalGas3__1.EnergyCommodityNaturalGas3__1Builder result;
			if (ntrlGas!=null) {
				result = ntrlGas;
			}
			else {
				result = ntrlGas = EnergyCommodityNaturalGas3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oil")
		public EnergyCommodityOil3__1.EnergyCommodityOil3__1Builder getOil() {
			return oil;
		}
		
		@Override
		public EnergyCommodityOil3__1.EnergyCommodityOil3__1Builder getOrCreateOil() {
			EnergyCommodityOil3__1.EnergyCommodityOil3__1Builder result;
			if (oil!=null) {
				result = oil;
			}
			else {
				result = oil = EnergyCommodityOil3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coal")
		public EnergyCommodityCoal2__1.EnergyCommodityCoal2__1Builder getCoal() {
			return coal;
		}
		
		@Override
		public EnergyCommodityCoal2__1.EnergyCommodityCoal2__1Builder getOrCreateCoal() {
			EnergyCommodityCoal2__1.EnergyCommodityCoal2__1Builder result;
			if (coal!=null) {
				result = coal;
			}
			else {
				result = coal = EnergyCommodityCoal2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intrNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrNrgy")
		public EnergyCommodityInterEnergy2__1.EnergyCommodityInterEnergy2__1Builder getIntrNrgy() {
			return intrNrgy;
		}
		
		@Override
		public EnergyCommodityInterEnergy2__1.EnergyCommodityInterEnergy2__1Builder getOrCreateIntrNrgy() {
			EnergyCommodityInterEnergy2__1.EnergyCommodityInterEnergy2__1Builder result;
			if (intrNrgy!=null) {
				result = intrNrgy;
			}
			else {
				result = intrNrgy = EnergyCommodityInterEnergy2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rnwblNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rnwblNrgy")
		public EnergyCommodityRenewableEnergy2__1.EnergyCommodityRenewableEnergy2__1Builder getRnwblNrgy() {
			return rnwblNrgy;
		}
		
		@Override
		public EnergyCommodityRenewableEnergy2__1.EnergyCommodityRenewableEnergy2__1Builder getOrCreateRnwblNrgy() {
			EnergyCommodityRenewableEnergy2__1.EnergyCommodityRenewableEnergy2__1Builder result;
			if (rnwblNrgy!=null) {
				result = rnwblNrgy;
			}
			else {
				result = rnwblNrgy = EnergyCommodityRenewableEnergy2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lghtEnd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lghtEnd")
		public EnergyCommodityLightEnd2__1.EnergyCommodityLightEnd2__1Builder getLghtEnd() {
			return lghtEnd;
		}
		
		@Override
		public EnergyCommodityLightEnd2__1.EnergyCommodityLightEnd2__1Builder getOrCreateLghtEnd() {
			EnergyCommodityLightEnd2__1.EnergyCommodityLightEnd2__1Builder result;
			if (lghtEnd!=null) {
				result = lghtEnd;
			}
			else {
				result = lghtEnd = EnergyCommodityLightEnd2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dstllts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dstllts")
		public EnergyCommodityDistillates2__1.EnergyCommodityDistillates2__1Builder getDstllts() {
			return dstllts;
		}
		
		@Override
		public EnergyCommodityDistillates2__1.EnergyCommodityDistillates2__1Builder getOrCreateDstllts() {
			EnergyCommodityDistillates2__1.EnergyCommodityDistillates2__1Builder result;
			if (dstllts!=null) {
				result = dstllts;
			}
			else {
				result = dstllts = EnergyCommodityDistillates2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnergyCommodityOther2__1.EnergyCommodityOther2__1Builder getOthr() {
			return othr;
		}
		
		@Override
		public EnergyCommodityOther2__1.EnergyCommodityOther2__1Builder getOrCreateOthr() {
			EnergyCommodityOther2__1.EnergyCommodityOther2__1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = EnergyCommodityOther2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("elctrcty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("elctrcty")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setElctrcty(EnergyCommodityElectricity2__1 _elctrcty) {
			this.elctrcty = _elctrcty == null ? null : _elctrcty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntrlGas")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntrlGas")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setNtrlGas(EnergyCommodityNaturalGas3__1 _ntrlGas) {
			this.ntrlGas = _ntrlGas == null ? null : _ntrlGas.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oil")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("oil")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setOil(EnergyCommodityOil3__1 _oil) {
			this.oil = _oil == null ? null : _oil.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coal")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setCoal(EnergyCommodityCoal2__1 _coal) {
			this.coal = _coal == null ? null : _coal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intrNrgy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intrNrgy")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setIntrNrgy(EnergyCommodityInterEnergy2__1 _intrNrgy) {
			this.intrNrgy = _intrNrgy == null ? null : _intrNrgy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rnwblNrgy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rnwblNrgy")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setRnwblNrgy(EnergyCommodityRenewableEnergy2__1 _rnwblNrgy) {
			this.rnwblNrgy = _rnwblNrgy == null ? null : _rnwblNrgy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lghtEnd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lghtEnd")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setLghtEnd(EnergyCommodityLightEnd2__1 _lghtEnd) {
			this.lghtEnd = _lghtEnd == null ? null : _lghtEnd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dstllts")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dstllts")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setDstllts(EnergyCommodityDistillates2__1 _dstllts) {
			this.dstllts = _dstllts == null ? null : _dstllts.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder setOthr(EnergyCommodityOther2__1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice__1 build() {
			return new AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder prune() {
			if (elctrcty!=null && !elctrcty.prune().hasData()) elctrcty = null;
			if (ntrlGas!=null && !ntrlGas.prune().hasData()) ntrlGas = null;
			if (oil!=null && !oil.prune().hasData()) oil = null;
			if (coal!=null && !coal.prune().hasData()) coal = null;
			if (intrNrgy!=null && !intrNrgy.prune().hasData()) intrNrgy = null;
			if (rnwblNrgy!=null && !rnwblNrgy.prune().hasData()) rnwblNrgy = null;
			if (lghtEnd!=null && !lghtEnd.prune().hasData()) lghtEnd = null;
			if (dstllts!=null && !dstllts.prune().hasData()) dstllts = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getElctrcty()!=null && getElctrcty().hasData()) return true;
			if (getNtrlGas()!=null && getNtrlGas().hasData()) return true;
			if (getOil()!=null && getOil().hasData()) return true;
			if (getCoal()!=null && getCoal().hasData()) return true;
			if (getIntrNrgy()!=null && getIntrNrgy().hasData()) return true;
			if (getRnwblNrgy()!=null && getRnwblNrgy().hasData()) return true;
			if (getLghtEnd()!=null && getLghtEnd().hasData()) return true;
			if (getDstllts()!=null && getDstllts().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder o = (AssetClassCommodityEnergy3Choice__1.AssetClassCommodityEnergy3Choice__1Builder) other;
			
			merger.mergeRosetta(getElctrcty(), o.getElctrcty(), this::setElctrcty);
			merger.mergeRosetta(getNtrlGas(), o.getNtrlGas(), this::setNtrlGas);
			merger.mergeRosetta(getOil(), o.getOil(), this::setOil);
			merger.mergeRosetta(getCoal(), o.getCoal(), this::setCoal);
			merger.mergeRosetta(getIntrNrgy(), o.getIntrNrgy(), this::setIntrNrgy);
			merger.mergeRosetta(getRnwblNrgy(), o.getRnwblNrgy(), this::setRnwblNrgy);
			merger.mergeRosetta(getLghtEnd(), o.getLghtEnd(), this::setLghtEnd);
			merger.mergeRosetta(getDstllts(), o.getDstllts(), this::setDstllts);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityEnergy3Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(elctrcty, _that.getElctrcty())) return false;
			if (!Objects.equals(ntrlGas, _that.getNtrlGas())) return false;
			if (!Objects.equals(oil, _that.getOil())) return false;
			if (!Objects.equals(coal, _that.getCoal())) return false;
			if (!Objects.equals(intrNrgy, _that.getIntrNrgy())) return false;
			if (!Objects.equals(rnwblNrgy, _that.getRnwblNrgy())) return false;
			if (!Objects.equals(lghtEnd, _that.getLghtEnd())) return false;
			if (!Objects.equals(dstllts, _that.getDstllts())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (elctrcty != null ? elctrcty.hashCode() : 0);
			_result = 31 * _result + (ntrlGas != null ? ntrlGas.hashCode() : 0);
			_result = 31 * _result + (oil != null ? oil.hashCode() : 0);
			_result = 31 * _result + (coal != null ? coal.hashCode() : 0);
			_result = 31 * _result + (intrNrgy != null ? intrNrgy.hashCode() : 0);
			_result = 31 * _result + (rnwblNrgy != null ? rnwblNrgy.hashCode() : 0);
			_result = 31 * _result + (lghtEnd != null ? lghtEnd.hashCode() : 0);
			_result = 31 * _result + (dstllts != null ? dstllts.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityEnergy3Choice__1Builder {" +
				"elctrcty=" + this.elctrcty + ", " +
				"ntrlGas=" + this.ntrlGas + ", " +
				"oil=" + this.oil + ", " +
				"coal=" + this.coal + ", " +
				"intrNrgy=" + this.intrNrgy + ", " +
				"rnwblNrgy=" + this.rnwblNrgy + ", " +
				"lghtEnd=" + this.lghtEnd + ", " +
				"dstllts=" + this.dstllts + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
