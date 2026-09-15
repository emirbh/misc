package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.AssetClassCommodityEnergy3ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is energy.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityEnergy3Choice", builder=AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityEnergy3Choice", model="iso20022", builder=AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityEnergy3Choice extends RosettaModelObject {

	AssetClassCommodityEnergy3ChoiceMeta metaData = new AssetClassCommodityEnergy3ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Definition of Electricity energy commodity derivative.
	 */
	EnergyCommodityElectricity2 getElctrcty();
	/**
	 * Definition of Natural Gas energy commodity derivative.
	 */
	EnergyCommodityNaturalGas3 getNtrlGas();
	/**
	 * Definition of Oil energy commodity derivative.
	 */
	EnergyCommodityOil3 getOil();
	/**
	 * Definition of Coal energy commodity derivative.
	 */
	EnergyCommodityCoal2 getCoal();
	/**
	 * Inter energy commodity derivative.
	 */
	EnergyCommodityInterEnergy2 getIntrNrgy();
	/**
	 * Renewable energy commodity derivative.
	 */
	EnergyCommodityRenewableEnergy2 getRnwblNrgy();
	/**
	 * Light end energy commodity derivative.
	 */
	EnergyCommodityLightEnd2 getLghtEnd();
	/**
	 * Distillates energy commodity derivative.
	 */
	EnergyCommodityDistillates2 getDstllts();
	/**
	 * Other energy commodity derivative.
	 */
	EnergyCommodityOther2 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityEnergy3Choice build();
	
	AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder toBuilder();
	
	static AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder builder() {
		return new AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityEnergy3Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityEnergy3Choice> getType() {
		return AssetClassCommodityEnergy3Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("elctrcty"), processor, EnergyCommodityElectricity2.class, getElctrcty());
		processRosetta(path.newSubPath("ntrlGas"), processor, EnergyCommodityNaturalGas3.class, getNtrlGas());
		processRosetta(path.newSubPath("oil"), processor, EnergyCommodityOil3.class, getOil());
		processRosetta(path.newSubPath("coal"), processor, EnergyCommodityCoal2.class, getCoal());
		processRosetta(path.newSubPath("intrNrgy"), processor, EnergyCommodityInterEnergy2.class, getIntrNrgy());
		processRosetta(path.newSubPath("rnwblNrgy"), processor, EnergyCommodityRenewableEnergy2.class, getRnwblNrgy());
		processRosetta(path.newSubPath("lghtEnd"), processor, EnergyCommodityLightEnd2.class, getLghtEnd());
		processRosetta(path.newSubPath("dstllts"), processor, EnergyCommodityDistillates2.class, getDstllts());
		processRosetta(path.newSubPath("othr"), processor, EnergyCommodityOther2.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityEnergy3ChoiceBuilder extends AssetClassCommodityEnergy3Choice, RosettaModelObjectBuilder {
		EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder getOrCreateElctrcty();
		@Override
		EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder getElctrcty();
		EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder getOrCreateNtrlGas();
		@Override
		EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder getNtrlGas();
		EnergyCommodityOil3.EnergyCommodityOil3Builder getOrCreateOil();
		@Override
		EnergyCommodityOil3.EnergyCommodityOil3Builder getOil();
		EnergyCommodityCoal2.EnergyCommodityCoal2Builder getOrCreateCoal();
		@Override
		EnergyCommodityCoal2.EnergyCommodityCoal2Builder getCoal();
		EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder getOrCreateIntrNrgy();
		@Override
		EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder getIntrNrgy();
		EnergyCommodityRenewableEnergy2.EnergyCommodityRenewableEnergy2Builder getOrCreateRnwblNrgy();
		@Override
		EnergyCommodityRenewableEnergy2.EnergyCommodityRenewableEnergy2Builder getRnwblNrgy();
		EnergyCommodityLightEnd2.EnergyCommodityLightEnd2Builder getOrCreateLghtEnd();
		@Override
		EnergyCommodityLightEnd2.EnergyCommodityLightEnd2Builder getLghtEnd();
		EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder getOrCreateDstllts();
		@Override
		EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder getDstllts();
		EnergyCommodityOther2.EnergyCommodityOther2Builder getOrCreateOthr();
		@Override
		EnergyCommodityOther2.EnergyCommodityOther2Builder getOthr();
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setElctrcty(EnergyCommodityElectricity2 elctrcty);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setNtrlGas(EnergyCommodityNaturalGas3 ntrlGas);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setOil(EnergyCommodityOil3 oil);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setCoal(EnergyCommodityCoal2 coal);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setIntrNrgy(EnergyCommodityInterEnergy2 intrNrgy);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setRnwblNrgy(EnergyCommodityRenewableEnergy2 rnwblNrgy);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setLghtEnd(EnergyCommodityLightEnd2 lghtEnd);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setDstllts(EnergyCommodityDistillates2 dstllts);
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setOthr(EnergyCommodityOther2 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("elctrcty"), processor, EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder.class, getElctrcty());
			processRosetta(path.newSubPath("ntrlGas"), processor, EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder.class, getNtrlGas());
			processRosetta(path.newSubPath("oil"), processor, EnergyCommodityOil3.EnergyCommodityOil3Builder.class, getOil());
			processRosetta(path.newSubPath("coal"), processor, EnergyCommodityCoal2.EnergyCommodityCoal2Builder.class, getCoal());
			processRosetta(path.newSubPath("intrNrgy"), processor, EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder.class, getIntrNrgy());
			processRosetta(path.newSubPath("rnwblNrgy"), processor, EnergyCommodityRenewableEnergy2.EnergyCommodityRenewableEnergy2Builder.class, getRnwblNrgy());
			processRosetta(path.newSubPath("lghtEnd"), processor, EnergyCommodityLightEnd2.EnergyCommodityLightEnd2Builder.class, getLghtEnd());
			processRosetta(path.newSubPath("dstllts"), processor, EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder.class, getDstllts());
			processRosetta(path.newSubPath("othr"), processor, EnergyCommodityOther2.EnergyCommodityOther2Builder.class, getOthr());
		}
		

		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityEnergy3Choice  ***********************/
	class AssetClassCommodityEnergy3ChoiceImpl implements AssetClassCommodityEnergy3Choice {
		private final EnergyCommodityElectricity2 elctrcty;
		private final EnergyCommodityNaturalGas3 ntrlGas;
		private final EnergyCommodityOil3 oil;
		private final EnergyCommodityCoal2 coal;
		private final EnergyCommodityInterEnergy2 intrNrgy;
		private final EnergyCommodityRenewableEnergy2 rnwblNrgy;
		private final EnergyCommodityLightEnd2 lghtEnd;
		private final EnergyCommodityDistillates2 dstllts;
		private final EnergyCommodityOther2 othr;
		
		protected AssetClassCommodityEnergy3ChoiceImpl(AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder builder) {
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
		public EnergyCommodityElectricity2 getElctrcty() {
			return elctrcty;
		}
		
		@Override
		@RosettaAttribute("ntrlGas")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrlGas")
		public EnergyCommodityNaturalGas3 getNtrlGas() {
			return ntrlGas;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oil")
		public EnergyCommodityOil3 getOil() {
			return oil;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coal")
		public EnergyCommodityCoal2 getCoal() {
			return coal;
		}
		
		@Override
		@RosettaAttribute("intrNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrNrgy")
		public EnergyCommodityInterEnergy2 getIntrNrgy() {
			return intrNrgy;
		}
		
		@Override
		@RosettaAttribute("rnwblNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rnwblNrgy")
		public EnergyCommodityRenewableEnergy2 getRnwblNrgy() {
			return rnwblNrgy;
		}
		
		@Override
		@RosettaAttribute("lghtEnd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lghtEnd")
		public EnergyCommodityLightEnd2 getLghtEnd() {
			return lghtEnd;
		}
		
		@Override
		@RosettaAttribute("dstllts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dstllts")
		public EnergyCommodityDistillates2 getDstllts() {
			return dstllts;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnergyCommodityOther2 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder toBuilder() {
			AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder builder) {
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
		
			AssetClassCommodityEnergy3Choice _that = getType().cast(o);
		
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
			return "AssetClassCommodityEnergy3Choice {" +
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

	/*********************** Builder Implementation of AssetClassCommodityEnergy3Choice  ***********************/
	class AssetClassCommodityEnergy3ChoiceBuilderImpl implements AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder {
	
		protected EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder elctrcty;
		protected EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder ntrlGas;
		protected EnergyCommodityOil3.EnergyCommodityOil3Builder oil;
		protected EnergyCommodityCoal2.EnergyCommodityCoal2Builder coal;
		protected EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder intrNrgy;
		protected EnergyCommodityRenewableEnergy2.EnergyCommodityRenewableEnergy2Builder rnwblNrgy;
		protected EnergyCommodityLightEnd2.EnergyCommodityLightEnd2Builder lghtEnd;
		protected EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder dstllts;
		protected EnergyCommodityOther2.EnergyCommodityOther2Builder othr;
		
		@Override
		@RosettaAttribute("elctrcty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("elctrcty")
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder getElctrcty() {
			return elctrcty;
		}
		
		@Override
		public EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder getOrCreateElctrcty() {
			EnergyCommodityElectricity2.EnergyCommodityElectricity2Builder result;
			if (elctrcty!=null) {
				result = elctrcty;
			}
			else {
				result = elctrcty = EnergyCommodityElectricity2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ntrlGas")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ntrlGas")
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder getNtrlGas() {
			return ntrlGas;
		}
		
		@Override
		public EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder getOrCreateNtrlGas() {
			EnergyCommodityNaturalGas3.EnergyCommodityNaturalGas3Builder result;
			if (ntrlGas!=null) {
				result = ntrlGas;
			}
			else {
				result = ntrlGas = EnergyCommodityNaturalGas3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("oil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("oil")
		public EnergyCommodityOil3.EnergyCommodityOil3Builder getOil() {
			return oil;
		}
		
		@Override
		public EnergyCommodityOil3.EnergyCommodityOil3Builder getOrCreateOil() {
			EnergyCommodityOil3.EnergyCommodityOil3Builder result;
			if (oil!=null) {
				result = oil;
			}
			else {
				result = oil = EnergyCommodityOil3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("coal")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coal")
		public EnergyCommodityCoal2.EnergyCommodityCoal2Builder getCoal() {
			return coal;
		}
		
		@Override
		public EnergyCommodityCoal2.EnergyCommodityCoal2Builder getOrCreateCoal() {
			EnergyCommodityCoal2.EnergyCommodityCoal2Builder result;
			if (coal!=null) {
				result = coal;
			}
			else {
				result = coal = EnergyCommodityCoal2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intrNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrNrgy")
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder getIntrNrgy() {
			return intrNrgy;
		}
		
		@Override
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder getOrCreateIntrNrgy() {
			EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder result;
			if (intrNrgy!=null) {
				result = intrNrgy;
			}
			else {
				result = intrNrgy = EnergyCommodityInterEnergy2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rnwblNrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rnwblNrgy")
		public EnergyCommodityRenewableEnergy2.EnergyCommodityRenewableEnergy2Builder getRnwblNrgy() {
			return rnwblNrgy;
		}
		
		@Override
		public EnergyCommodityRenewableEnergy2.EnergyCommodityRenewableEnergy2Builder getOrCreateRnwblNrgy() {
			EnergyCommodityRenewableEnergy2.EnergyCommodityRenewableEnergy2Builder result;
			if (rnwblNrgy!=null) {
				result = rnwblNrgy;
			}
			else {
				result = rnwblNrgy = EnergyCommodityRenewableEnergy2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lghtEnd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("lghtEnd")
		public EnergyCommodityLightEnd2.EnergyCommodityLightEnd2Builder getLghtEnd() {
			return lghtEnd;
		}
		
		@Override
		public EnergyCommodityLightEnd2.EnergyCommodityLightEnd2Builder getOrCreateLghtEnd() {
			EnergyCommodityLightEnd2.EnergyCommodityLightEnd2Builder result;
			if (lghtEnd!=null) {
				result = lghtEnd;
			}
			else {
				result = lghtEnd = EnergyCommodityLightEnd2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dstllts")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dstllts")
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder getDstllts() {
			return dstllts;
		}
		
		@Override
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder getOrCreateDstllts() {
			EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder result;
			if (dstllts!=null) {
				result = dstllts;
			}
			else {
				result = dstllts = EnergyCommodityDistillates2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public EnergyCommodityOther2.EnergyCommodityOther2Builder getOthr() {
			return othr;
		}
		
		@Override
		public EnergyCommodityOther2.EnergyCommodityOther2Builder getOrCreateOthr() {
			EnergyCommodityOther2.EnergyCommodityOther2Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = EnergyCommodityOther2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("elctrcty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("elctrcty")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setElctrcty(EnergyCommodityElectricity2 _elctrcty) {
			this.elctrcty = _elctrcty == null ? null : _elctrcty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ntrlGas")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ntrlGas")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setNtrlGas(EnergyCommodityNaturalGas3 _ntrlGas) {
			this.ntrlGas = _ntrlGas == null ? null : _ntrlGas.toBuilder();
			return this;
		}
		
		@RosettaAttribute("oil")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("oil")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setOil(EnergyCommodityOil3 _oil) {
			this.oil = _oil == null ? null : _oil.toBuilder();
			return this;
		}
		
		@RosettaAttribute("coal")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coal")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setCoal(EnergyCommodityCoal2 _coal) {
			this.coal = _coal == null ? null : _coal.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intrNrgy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intrNrgy")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setIntrNrgy(EnergyCommodityInterEnergy2 _intrNrgy) {
			this.intrNrgy = _intrNrgy == null ? null : _intrNrgy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rnwblNrgy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rnwblNrgy")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setRnwblNrgy(EnergyCommodityRenewableEnergy2 _rnwblNrgy) {
			this.rnwblNrgy = _rnwblNrgy == null ? null : _rnwblNrgy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lghtEnd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lghtEnd")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setLghtEnd(EnergyCommodityLightEnd2 _lghtEnd) {
			this.lghtEnd = _lghtEnd == null ? null : _lghtEnd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dstllts")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dstllts")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setDstllts(EnergyCommodityDistillates2 _dstllts) {
			this.dstllts = _dstllts == null ? null : _dstllts.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder setOthr(EnergyCommodityOther2 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice build() {
			return new AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder prune() {
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
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder o = (AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder) other;
			
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
		
			AssetClassCommodityEnergy3Choice _that = getType().cast(o);
		
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
			return "AssetClassCommodityEnergy3ChoiceBuilder {" +
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
