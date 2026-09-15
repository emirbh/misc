package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.AssetClassCommodityAgricultural6ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is agricultural.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityAgricultural6Choice", builder=AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityAgricultural6Choice", model="iso20022", builder=AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityAgricultural6Choice extends RosettaModelObject {

	AssetClassCommodityAgricultural6ChoiceMeta metaData = new AssetClassCommodityAgricultural6ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Grain oil seed agricultural commodity derivative.
	 */
	AgriculturalCommodityOilSeed2 getGrnOilSeed();
	/**
	 * Soft agricultural commodity derivative.
	 */
	AgriculturalCommoditySoft2 getSoft();
	/**
	 * Potato agricultural commodity derivative.
	 */
	AgriculturalCommodityPotato2 getPtt();
	/**
	 * Olive oil agricultural commodity derivative.
	 */
	AgriculturalCommodityOliveOil3 getOlvOil();
	/**
	 * Dairy agricultural commodity derivative.
	 */
	AgriculturalCommodityDairy2 getDairy();
	/**
	 * Forestry agricultural commodity derivative.
	 */
	AgriculturalCommodityForestry2 getFrstry();
	/**
	 * Seafood agricultural commodity derivative.
	 */
	AgriculturalCommoditySeafood2 getSfd();
	/**
	 * Livestock agricultural commodity derivative.
	 */
	AgriculturalCommodityLiveStock2 getLiveStock();
	/**
	 * Grain agricultural commodity derivative.
	 */
	AgriculturalCommodityGrain3 getGrn();
	/**
	 * Other agricultural commodity derivative.
	 */
	AgriculturalCommodityOther2 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityAgricultural6Choice build();
	
	AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder toBuilder();
	
	static AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder builder() {
		return new AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityAgricultural6Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityAgricultural6Choice> getType() {
		return AssetClassCommodityAgricultural6Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("grnOilSeed"), processor, AgriculturalCommodityOilSeed2.class, getGrnOilSeed());
		processRosetta(path.newSubPath("soft"), processor, AgriculturalCommoditySoft2.class, getSoft());
		processRosetta(path.newSubPath("ptt"), processor, AgriculturalCommodityPotato2.class, getPtt());
		processRosetta(path.newSubPath("olvOil"), processor, AgriculturalCommodityOliveOil3.class, getOlvOil());
		processRosetta(path.newSubPath("dairy"), processor, AgriculturalCommodityDairy2.class, getDairy());
		processRosetta(path.newSubPath("frstry"), processor, AgriculturalCommodityForestry2.class, getFrstry());
		processRosetta(path.newSubPath("sfd"), processor, AgriculturalCommoditySeafood2.class, getSfd());
		processRosetta(path.newSubPath("liveStock"), processor, AgriculturalCommodityLiveStock2.class, getLiveStock());
		processRosetta(path.newSubPath("grn"), processor, AgriculturalCommodityGrain3.class, getGrn());
		processRosetta(path.newSubPath("othr"), processor, AgriculturalCommodityOther2.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityAgricultural6ChoiceBuilder extends AssetClassCommodityAgricultural6Choice, RosettaModelObjectBuilder {
		AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder getOrCreateGrnOilSeed();
		@Override
		AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder getGrnOilSeed();
		AgriculturalCommoditySoft2.AgriculturalCommoditySoft2Builder getOrCreateSoft();
		@Override
		AgriculturalCommoditySoft2.AgriculturalCommoditySoft2Builder getSoft();
		AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder getOrCreatePtt();
		@Override
		AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder getPtt();
		AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder getOrCreateOlvOil();
		@Override
		AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder getOlvOil();
		AgriculturalCommodityDairy2.AgriculturalCommodityDairy2Builder getOrCreateDairy();
		@Override
		AgriculturalCommodityDairy2.AgriculturalCommodityDairy2Builder getDairy();
		AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder getOrCreateFrstry();
		@Override
		AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder getFrstry();
		AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder getOrCreateSfd();
		@Override
		AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder getSfd();
		AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder getOrCreateLiveStock();
		@Override
		AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder getLiveStock();
		AgriculturalCommodityGrain3.AgriculturalCommodityGrain3Builder getOrCreateGrn();
		@Override
		AgriculturalCommodityGrain3.AgriculturalCommodityGrain3Builder getGrn();
		AgriculturalCommodityOther2.AgriculturalCommodityOther2Builder getOrCreateOthr();
		@Override
		AgriculturalCommodityOther2.AgriculturalCommodityOther2Builder getOthr();
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setGrnOilSeed(AgriculturalCommodityOilSeed2 grnOilSeed);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setSoft(AgriculturalCommoditySoft2 soft);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setPtt(AgriculturalCommodityPotato2 ptt);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setOlvOil(AgriculturalCommodityOliveOil3 olvOil);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setDairy(AgriculturalCommodityDairy2 dairy);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setFrstry(AgriculturalCommodityForestry2 frstry);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setSfd(AgriculturalCommoditySeafood2 sfd);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setLiveStock(AgriculturalCommodityLiveStock2 liveStock);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setGrn(AgriculturalCommodityGrain3 grn);
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setOthr(AgriculturalCommodityOther2 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("grnOilSeed"), processor, AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder.class, getGrnOilSeed());
			processRosetta(path.newSubPath("soft"), processor, AgriculturalCommoditySoft2.AgriculturalCommoditySoft2Builder.class, getSoft());
			processRosetta(path.newSubPath("ptt"), processor, AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder.class, getPtt());
			processRosetta(path.newSubPath("olvOil"), processor, AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder.class, getOlvOil());
			processRosetta(path.newSubPath("dairy"), processor, AgriculturalCommodityDairy2.AgriculturalCommodityDairy2Builder.class, getDairy());
			processRosetta(path.newSubPath("frstry"), processor, AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder.class, getFrstry());
			processRosetta(path.newSubPath("sfd"), processor, AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder.class, getSfd());
			processRosetta(path.newSubPath("liveStock"), processor, AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder.class, getLiveStock());
			processRosetta(path.newSubPath("grn"), processor, AgriculturalCommodityGrain3.AgriculturalCommodityGrain3Builder.class, getGrn());
			processRosetta(path.newSubPath("othr"), processor, AgriculturalCommodityOther2.AgriculturalCommodityOther2Builder.class, getOthr());
		}
		

		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityAgricultural6Choice  ***********************/
	class AssetClassCommodityAgricultural6ChoiceImpl implements AssetClassCommodityAgricultural6Choice {
		private final AgriculturalCommodityOilSeed2 grnOilSeed;
		private final AgriculturalCommoditySoft2 soft;
		private final AgriculturalCommodityPotato2 ptt;
		private final AgriculturalCommodityOliveOil3 olvOil;
		private final AgriculturalCommodityDairy2 dairy;
		private final AgriculturalCommodityForestry2 frstry;
		private final AgriculturalCommoditySeafood2 sfd;
		private final AgriculturalCommodityLiveStock2 liveStock;
		private final AgriculturalCommodityGrain3 grn;
		private final AgriculturalCommodityOther2 othr;
		
		protected AssetClassCommodityAgricultural6ChoiceImpl(AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder builder) {
			this.grnOilSeed = ofNullable(builder.getGrnOilSeed()).map(f->f.build()).orElse(null);
			this.soft = ofNullable(builder.getSoft()).map(f->f.build()).orElse(null);
			this.ptt = ofNullable(builder.getPtt()).map(f->f.build()).orElse(null);
			this.olvOil = ofNullable(builder.getOlvOil()).map(f->f.build()).orElse(null);
			this.dairy = ofNullable(builder.getDairy()).map(f->f.build()).orElse(null);
			this.frstry = ofNullable(builder.getFrstry()).map(f->f.build()).orElse(null);
			this.sfd = ofNullable(builder.getSfd()).map(f->f.build()).orElse(null);
			this.liveStock = ofNullable(builder.getLiveStock()).map(f->f.build()).orElse(null);
			this.grn = ofNullable(builder.getGrn()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("grnOilSeed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grnOilSeed")
		public AgriculturalCommodityOilSeed2 getGrnOilSeed() {
			return grnOilSeed;
		}
		
		@Override
		@RosettaAttribute("soft")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("soft")
		public AgriculturalCommoditySoft2 getSoft() {
			return soft;
		}
		
		@Override
		@RosettaAttribute("ptt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptt")
		public AgriculturalCommodityPotato2 getPtt() {
			return ptt;
		}
		
		@Override
		@RosettaAttribute("olvOil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("olvOil")
		public AgriculturalCommodityOliveOil3 getOlvOil() {
			return olvOil;
		}
		
		@Override
		@RosettaAttribute("dairy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dairy")
		public AgriculturalCommodityDairy2 getDairy() {
			return dairy;
		}
		
		@Override
		@RosettaAttribute("frstry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstry")
		public AgriculturalCommodityForestry2 getFrstry() {
			return frstry;
		}
		
		@Override
		@RosettaAttribute("sfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sfd")
		public AgriculturalCommoditySeafood2 getSfd() {
			return sfd;
		}
		
		@Override
		@RosettaAttribute("liveStock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("liveStock")
		public AgriculturalCommodityLiveStock2 getLiveStock() {
			return liveStock;
		}
		
		@Override
		@RosettaAttribute("grn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grn")
		public AgriculturalCommodityGrain3 getGrn() {
			return grn;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public AgriculturalCommodityOther2 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder toBuilder() {
			AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder builder) {
			ofNullable(getGrnOilSeed()).ifPresent(builder::setGrnOilSeed);
			ofNullable(getSoft()).ifPresent(builder::setSoft);
			ofNullable(getPtt()).ifPresent(builder::setPtt);
			ofNullable(getOlvOil()).ifPresent(builder::setOlvOil);
			ofNullable(getDairy()).ifPresent(builder::setDairy);
			ofNullable(getFrstry()).ifPresent(builder::setFrstry);
			ofNullable(getSfd()).ifPresent(builder::setSfd);
			ofNullable(getLiveStock()).ifPresent(builder::setLiveStock);
			ofNullable(getGrn()).ifPresent(builder::setGrn);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityAgricultural6Choice _that = getType().cast(o);
		
			if (!Objects.equals(grnOilSeed, _that.getGrnOilSeed())) return false;
			if (!Objects.equals(soft, _that.getSoft())) return false;
			if (!Objects.equals(ptt, _that.getPtt())) return false;
			if (!Objects.equals(olvOil, _that.getOlvOil())) return false;
			if (!Objects.equals(dairy, _that.getDairy())) return false;
			if (!Objects.equals(frstry, _that.getFrstry())) return false;
			if (!Objects.equals(sfd, _that.getSfd())) return false;
			if (!Objects.equals(liveStock, _that.getLiveStock())) return false;
			if (!Objects.equals(grn, _that.getGrn())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grnOilSeed != null ? grnOilSeed.hashCode() : 0);
			_result = 31 * _result + (soft != null ? soft.hashCode() : 0);
			_result = 31 * _result + (ptt != null ? ptt.hashCode() : 0);
			_result = 31 * _result + (olvOil != null ? olvOil.hashCode() : 0);
			_result = 31 * _result + (dairy != null ? dairy.hashCode() : 0);
			_result = 31 * _result + (frstry != null ? frstry.hashCode() : 0);
			_result = 31 * _result + (sfd != null ? sfd.hashCode() : 0);
			_result = 31 * _result + (liveStock != null ? liveStock.hashCode() : 0);
			_result = 31 * _result + (grn != null ? grn.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityAgricultural6Choice {" +
				"grnOilSeed=" + this.grnOilSeed + ", " +
				"soft=" + this.soft + ", " +
				"ptt=" + this.ptt + ", " +
				"olvOil=" + this.olvOil + ", " +
				"dairy=" + this.dairy + ", " +
				"frstry=" + this.frstry + ", " +
				"sfd=" + this.sfd + ", " +
				"liveStock=" + this.liveStock + ", " +
				"grn=" + this.grn + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityAgricultural6Choice  ***********************/
	class AssetClassCommodityAgricultural6ChoiceBuilderImpl implements AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder {
	
		protected AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder grnOilSeed;
		protected AgriculturalCommoditySoft2.AgriculturalCommoditySoft2Builder soft;
		protected AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder ptt;
		protected AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder olvOil;
		protected AgriculturalCommodityDairy2.AgriculturalCommodityDairy2Builder dairy;
		protected AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder frstry;
		protected AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder sfd;
		protected AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder liveStock;
		protected AgriculturalCommodityGrain3.AgriculturalCommodityGrain3Builder grn;
		protected AgriculturalCommodityOther2.AgriculturalCommodityOther2Builder othr;
		
		@Override
		@RosettaAttribute("grnOilSeed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grnOilSeed")
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder getGrnOilSeed() {
			return grnOilSeed;
		}
		
		@Override
		public AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder getOrCreateGrnOilSeed() {
			AgriculturalCommodityOilSeed2.AgriculturalCommodityOilSeed2Builder result;
			if (grnOilSeed!=null) {
				result = grnOilSeed;
			}
			else {
				result = grnOilSeed = AgriculturalCommodityOilSeed2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("soft")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("soft")
		public AgriculturalCommoditySoft2.AgriculturalCommoditySoft2Builder getSoft() {
			return soft;
		}
		
		@Override
		public AgriculturalCommoditySoft2.AgriculturalCommoditySoft2Builder getOrCreateSoft() {
			AgriculturalCommoditySoft2.AgriculturalCommoditySoft2Builder result;
			if (soft!=null) {
				result = soft;
			}
			else {
				result = soft = AgriculturalCommoditySoft2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ptt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptt")
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder getPtt() {
			return ptt;
		}
		
		@Override
		public AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder getOrCreatePtt() {
			AgriculturalCommodityPotato2.AgriculturalCommodityPotato2Builder result;
			if (ptt!=null) {
				result = ptt;
			}
			else {
				result = ptt = AgriculturalCommodityPotato2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("olvOil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("olvOil")
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder getOlvOil() {
			return olvOil;
		}
		
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder getOrCreateOlvOil() {
			AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder result;
			if (olvOil!=null) {
				result = olvOil;
			}
			else {
				result = olvOil = AgriculturalCommodityOliveOil3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dairy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dairy")
		public AgriculturalCommodityDairy2.AgriculturalCommodityDairy2Builder getDairy() {
			return dairy;
		}
		
		@Override
		public AgriculturalCommodityDairy2.AgriculturalCommodityDairy2Builder getOrCreateDairy() {
			AgriculturalCommodityDairy2.AgriculturalCommodityDairy2Builder result;
			if (dairy!=null) {
				result = dairy;
			}
			else {
				result = dairy = AgriculturalCommodityDairy2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("frstry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstry")
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder getFrstry() {
			return frstry;
		}
		
		@Override
		public AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder getOrCreateFrstry() {
			AgriculturalCommodityForestry2.AgriculturalCommodityForestry2Builder result;
			if (frstry!=null) {
				result = frstry;
			}
			else {
				result = frstry = AgriculturalCommodityForestry2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sfd")
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder getSfd() {
			return sfd;
		}
		
		@Override
		public AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder getOrCreateSfd() {
			AgriculturalCommoditySeafood2.AgriculturalCommoditySeafood2Builder result;
			if (sfd!=null) {
				result = sfd;
			}
			else {
				result = sfd = AgriculturalCommoditySeafood2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("liveStock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("liveStock")
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder getLiveStock() {
			return liveStock;
		}
		
		@Override
		public AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder getOrCreateLiveStock() {
			AgriculturalCommodityLiveStock2.AgriculturalCommodityLiveStock2Builder result;
			if (liveStock!=null) {
				result = liveStock;
			}
			else {
				result = liveStock = AgriculturalCommodityLiveStock2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grn")
		public AgriculturalCommodityGrain3.AgriculturalCommodityGrain3Builder getGrn() {
			return grn;
		}
		
		@Override
		public AgriculturalCommodityGrain3.AgriculturalCommodityGrain3Builder getOrCreateGrn() {
			AgriculturalCommodityGrain3.AgriculturalCommodityGrain3Builder result;
			if (grn!=null) {
				result = grn;
			}
			else {
				result = grn = AgriculturalCommodityGrain3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public AgriculturalCommodityOther2.AgriculturalCommodityOther2Builder getOthr() {
			return othr;
		}
		
		@Override
		public AgriculturalCommodityOther2.AgriculturalCommodityOther2Builder getOrCreateOthr() {
			AgriculturalCommodityOther2.AgriculturalCommodityOther2Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = AgriculturalCommodityOther2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("grnOilSeed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("grnOilSeed")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setGrnOilSeed(AgriculturalCommodityOilSeed2 _grnOilSeed) {
			this.grnOilSeed = _grnOilSeed == null ? null : _grnOilSeed.toBuilder();
			return this;
		}
		
		@RosettaAttribute("soft")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("soft")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setSoft(AgriculturalCommoditySoft2 _soft) {
			this.soft = _soft == null ? null : _soft.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ptt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptt")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setPtt(AgriculturalCommodityPotato2 _ptt) {
			this.ptt = _ptt == null ? null : _ptt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("olvOil")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("olvOil")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setOlvOil(AgriculturalCommodityOliveOil3 _olvOil) {
			this.olvOil = _olvOil == null ? null : _olvOil.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dairy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dairy")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setDairy(AgriculturalCommodityDairy2 _dairy) {
			this.dairy = _dairy == null ? null : _dairy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("frstry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frstry")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setFrstry(AgriculturalCommodityForestry2 _frstry) {
			this.frstry = _frstry == null ? null : _frstry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sfd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sfd")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setSfd(AgriculturalCommoditySeafood2 _sfd) {
			this.sfd = _sfd == null ? null : _sfd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("liveStock")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("liveStock")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setLiveStock(AgriculturalCommodityLiveStock2 _liveStock) {
			this.liveStock = _liveStock == null ? null : _liveStock.toBuilder();
			return this;
		}
		
		@RosettaAttribute("grn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("grn")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setGrn(AgriculturalCommodityGrain3 _grn) {
			this.grn = _grn == null ? null : _grn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder setOthr(AgriculturalCommodityOther2 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice build() {
			return new AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder prune() {
			if (grnOilSeed!=null && !grnOilSeed.prune().hasData()) grnOilSeed = null;
			if (soft!=null && !soft.prune().hasData()) soft = null;
			if (ptt!=null && !ptt.prune().hasData()) ptt = null;
			if (olvOil!=null && !olvOil.prune().hasData()) olvOil = null;
			if (dairy!=null && !dairy.prune().hasData()) dairy = null;
			if (frstry!=null && !frstry.prune().hasData()) frstry = null;
			if (sfd!=null && !sfd.prune().hasData()) sfd = null;
			if (liveStock!=null && !liveStock.prune().hasData()) liveStock = null;
			if (grn!=null && !grn.prune().hasData()) grn = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGrnOilSeed()!=null && getGrnOilSeed().hasData()) return true;
			if (getSoft()!=null && getSoft().hasData()) return true;
			if (getPtt()!=null && getPtt().hasData()) return true;
			if (getOlvOil()!=null && getOlvOil().hasData()) return true;
			if (getDairy()!=null && getDairy().hasData()) return true;
			if (getFrstry()!=null && getFrstry().hasData()) return true;
			if (getSfd()!=null && getSfd().hasData()) return true;
			if (getLiveStock()!=null && getLiveStock().hasData()) return true;
			if (getGrn()!=null && getGrn().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder o = (AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder) other;
			
			merger.mergeRosetta(getGrnOilSeed(), o.getGrnOilSeed(), this::setGrnOilSeed);
			merger.mergeRosetta(getSoft(), o.getSoft(), this::setSoft);
			merger.mergeRosetta(getPtt(), o.getPtt(), this::setPtt);
			merger.mergeRosetta(getOlvOil(), o.getOlvOil(), this::setOlvOil);
			merger.mergeRosetta(getDairy(), o.getDairy(), this::setDairy);
			merger.mergeRosetta(getFrstry(), o.getFrstry(), this::setFrstry);
			merger.mergeRosetta(getSfd(), o.getSfd(), this::setSfd);
			merger.mergeRosetta(getLiveStock(), o.getLiveStock(), this::setLiveStock);
			merger.mergeRosetta(getGrn(), o.getGrn(), this::setGrn);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityAgricultural6Choice _that = getType().cast(o);
		
			if (!Objects.equals(grnOilSeed, _that.getGrnOilSeed())) return false;
			if (!Objects.equals(soft, _that.getSoft())) return false;
			if (!Objects.equals(ptt, _that.getPtt())) return false;
			if (!Objects.equals(olvOil, _that.getOlvOil())) return false;
			if (!Objects.equals(dairy, _that.getDairy())) return false;
			if (!Objects.equals(frstry, _that.getFrstry())) return false;
			if (!Objects.equals(sfd, _that.getSfd())) return false;
			if (!Objects.equals(liveStock, _that.getLiveStock())) return false;
			if (!Objects.equals(grn, _that.getGrn())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grnOilSeed != null ? grnOilSeed.hashCode() : 0);
			_result = 31 * _result + (soft != null ? soft.hashCode() : 0);
			_result = 31 * _result + (ptt != null ? ptt.hashCode() : 0);
			_result = 31 * _result + (olvOil != null ? olvOil.hashCode() : 0);
			_result = 31 * _result + (dairy != null ? dairy.hashCode() : 0);
			_result = 31 * _result + (frstry != null ? frstry.hashCode() : 0);
			_result = 31 * _result + (sfd != null ? sfd.hashCode() : 0);
			_result = 31 * _result + (liveStock != null ? liveStock.hashCode() : 0);
			_result = 31 * _result + (grn != null ? grn.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityAgricultural6ChoiceBuilder {" +
				"grnOilSeed=" + this.grnOilSeed + ", " +
				"soft=" + this.soft + ", " +
				"ptt=" + this.ptt + ", " +
				"olvOil=" + this.olvOil + ", " +
				"dairy=" + this.dairy + ", " +
				"frstry=" + this.frstry + ", " +
				"sfd=" + this.sfd + ", " +
				"liveStock=" + this.liveStock + ", " +
				"grn=" + this.grn + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
