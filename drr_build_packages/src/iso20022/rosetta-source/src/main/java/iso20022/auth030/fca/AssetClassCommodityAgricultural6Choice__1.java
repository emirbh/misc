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
import iso20022.auth030.fca.meta.AssetClassCommodityAgricultural6Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is agricultural.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityAgricultural6Choice__1", builder=AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityAgricultural6Choice__1", model="iso20022", builder=AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityAgricultural6Choice__1 extends RosettaModelObject {

	AssetClassCommodityAgricultural6Choice__1Meta metaData = new AssetClassCommodityAgricultural6Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Grain oil seed agricultural commodity derivative.
	 */
	AgriculturalCommodityOilSeed2__1 getGrnOilSeed();
	/**
	 * Soft agricultural commodity derivative.
	 */
	AgriculturalCommoditySoft2__1 getSoft();
	/**
	 * Potato agricultural commodity derivative.
	 */
	AgriculturalCommodityPotato2__1 getPtt();
	/**
	 * Olive oil agricultural commodity derivative.
	 */
	AgriculturalCommodityOliveOil3__1 getOlvOil();
	/**
	 * Dairy agricultural commodity derivative.
	 */
	AgriculturalCommodityDairy2__1 getDairy();
	/**
	 * Forestry agricultural commodity derivative.
	 */
	AgriculturalCommodityForestry2__1 getFrstry();
	/**
	 * Seafood agricultural commodity derivative.
	 */
	AgriculturalCommoditySeafood2__1 getSfd();
	/**
	 * Livestock agricultural commodity derivative.
	 */
	AgriculturalCommodityLiveStock2__1 getLiveStock();
	/**
	 * Grain agricultural commodity derivative.
	 */
	AgriculturalCommodityGrain3__1 getGrn();
	/**
	 * Other agricultural commodity derivative.
	 */
	AgriculturalCommodityOther2__1 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityAgricultural6Choice__1 build();
	
	AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder toBuilder();
	
	static AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder builder() {
		return new AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityAgricultural6Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityAgricultural6Choice__1> getType() {
		return AssetClassCommodityAgricultural6Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("grnOilSeed"), processor, AgriculturalCommodityOilSeed2__1.class, getGrnOilSeed());
		processRosetta(path.newSubPath("soft"), processor, AgriculturalCommoditySoft2__1.class, getSoft());
		processRosetta(path.newSubPath("ptt"), processor, AgriculturalCommodityPotato2__1.class, getPtt());
		processRosetta(path.newSubPath("olvOil"), processor, AgriculturalCommodityOliveOil3__1.class, getOlvOil());
		processRosetta(path.newSubPath("dairy"), processor, AgriculturalCommodityDairy2__1.class, getDairy());
		processRosetta(path.newSubPath("frstry"), processor, AgriculturalCommodityForestry2__1.class, getFrstry());
		processRosetta(path.newSubPath("sfd"), processor, AgriculturalCommoditySeafood2__1.class, getSfd());
		processRosetta(path.newSubPath("liveStock"), processor, AgriculturalCommodityLiveStock2__1.class, getLiveStock());
		processRosetta(path.newSubPath("grn"), processor, AgriculturalCommodityGrain3__1.class, getGrn());
		processRosetta(path.newSubPath("othr"), processor, AgriculturalCommodityOther2__1.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityAgricultural6Choice__1Builder extends AssetClassCommodityAgricultural6Choice__1, RosettaModelObjectBuilder {
		AgriculturalCommodityOilSeed2__1.AgriculturalCommodityOilSeed2__1Builder getOrCreateGrnOilSeed();
		@Override
		AgriculturalCommodityOilSeed2__1.AgriculturalCommodityOilSeed2__1Builder getGrnOilSeed();
		AgriculturalCommoditySoft2__1.AgriculturalCommoditySoft2__1Builder getOrCreateSoft();
		@Override
		AgriculturalCommoditySoft2__1.AgriculturalCommoditySoft2__1Builder getSoft();
		AgriculturalCommodityPotato2__1.AgriculturalCommodityPotato2__1Builder getOrCreatePtt();
		@Override
		AgriculturalCommodityPotato2__1.AgriculturalCommodityPotato2__1Builder getPtt();
		AgriculturalCommodityOliveOil3__1.AgriculturalCommodityOliveOil3__1Builder getOrCreateOlvOil();
		@Override
		AgriculturalCommodityOliveOil3__1.AgriculturalCommodityOliveOil3__1Builder getOlvOil();
		AgriculturalCommodityDairy2__1.AgriculturalCommodityDairy2__1Builder getOrCreateDairy();
		@Override
		AgriculturalCommodityDairy2__1.AgriculturalCommodityDairy2__1Builder getDairy();
		AgriculturalCommodityForestry2__1.AgriculturalCommodityForestry2__1Builder getOrCreateFrstry();
		@Override
		AgriculturalCommodityForestry2__1.AgriculturalCommodityForestry2__1Builder getFrstry();
		AgriculturalCommoditySeafood2__1.AgriculturalCommoditySeafood2__1Builder getOrCreateSfd();
		@Override
		AgriculturalCommoditySeafood2__1.AgriculturalCommoditySeafood2__1Builder getSfd();
		AgriculturalCommodityLiveStock2__1.AgriculturalCommodityLiveStock2__1Builder getOrCreateLiveStock();
		@Override
		AgriculturalCommodityLiveStock2__1.AgriculturalCommodityLiveStock2__1Builder getLiveStock();
		AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder getOrCreateGrn();
		@Override
		AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder getGrn();
		AgriculturalCommodityOther2__1.AgriculturalCommodityOther2__1Builder getOrCreateOthr();
		@Override
		AgriculturalCommodityOther2__1.AgriculturalCommodityOther2__1Builder getOthr();
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setGrnOilSeed(AgriculturalCommodityOilSeed2__1 grnOilSeed);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setSoft(AgriculturalCommoditySoft2__1 soft);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setPtt(AgriculturalCommodityPotato2__1 ptt);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setOlvOil(AgriculturalCommodityOliveOil3__1 olvOil);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setDairy(AgriculturalCommodityDairy2__1 dairy);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setFrstry(AgriculturalCommodityForestry2__1 frstry);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setSfd(AgriculturalCommoditySeafood2__1 sfd);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setLiveStock(AgriculturalCommodityLiveStock2__1 liveStock);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setGrn(AgriculturalCommodityGrain3__1 grn);
		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setOthr(AgriculturalCommodityOther2__1 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("grnOilSeed"), processor, AgriculturalCommodityOilSeed2__1.AgriculturalCommodityOilSeed2__1Builder.class, getGrnOilSeed());
			processRosetta(path.newSubPath("soft"), processor, AgriculturalCommoditySoft2__1.AgriculturalCommoditySoft2__1Builder.class, getSoft());
			processRosetta(path.newSubPath("ptt"), processor, AgriculturalCommodityPotato2__1.AgriculturalCommodityPotato2__1Builder.class, getPtt());
			processRosetta(path.newSubPath("olvOil"), processor, AgriculturalCommodityOliveOil3__1.AgriculturalCommodityOliveOil3__1Builder.class, getOlvOil());
			processRosetta(path.newSubPath("dairy"), processor, AgriculturalCommodityDairy2__1.AgriculturalCommodityDairy2__1Builder.class, getDairy());
			processRosetta(path.newSubPath("frstry"), processor, AgriculturalCommodityForestry2__1.AgriculturalCommodityForestry2__1Builder.class, getFrstry());
			processRosetta(path.newSubPath("sfd"), processor, AgriculturalCommoditySeafood2__1.AgriculturalCommoditySeafood2__1Builder.class, getSfd());
			processRosetta(path.newSubPath("liveStock"), processor, AgriculturalCommodityLiveStock2__1.AgriculturalCommodityLiveStock2__1Builder.class, getLiveStock());
			processRosetta(path.newSubPath("grn"), processor, AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder.class, getGrn());
			processRosetta(path.newSubPath("othr"), processor, AgriculturalCommodityOther2__1.AgriculturalCommodityOther2__1Builder.class, getOthr());
		}
		

		AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityAgricultural6Choice__1  ***********************/
	class AssetClassCommodityAgricultural6Choice__1Impl implements AssetClassCommodityAgricultural6Choice__1 {
		private final AgriculturalCommodityOilSeed2__1 grnOilSeed;
		private final AgriculturalCommoditySoft2__1 soft;
		private final AgriculturalCommodityPotato2__1 ptt;
		private final AgriculturalCommodityOliveOil3__1 olvOil;
		private final AgriculturalCommodityDairy2__1 dairy;
		private final AgriculturalCommodityForestry2__1 frstry;
		private final AgriculturalCommoditySeafood2__1 sfd;
		private final AgriculturalCommodityLiveStock2__1 liveStock;
		private final AgriculturalCommodityGrain3__1 grn;
		private final AgriculturalCommodityOther2__1 othr;
		
		protected AssetClassCommodityAgricultural6Choice__1Impl(AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder builder) {
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
		public AgriculturalCommodityOilSeed2__1 getGrnOilSeed() {
			return grnOilSeed;
		}
		
		@Override
		@RosettaAttribute("soft")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("soft")
		public AgriculturalCommoditySoft2__1 getSoft() {
			return soft;
		}
		
		@Override
		@RosettaAttribute("ptt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptt")
		public AgriculturalCommodityPotato2__1 getPtt() {
			return ptt;
		}
		
		@Override
		@RosettaAttribute("olvOil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("olvOil")
		public AgriculturalCommodityOliveOil3__1 getOlvOil() {
			return olvOil;
		}
		
		@Override
		@RosettaAttribute("dairy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dairy")
		public AgriculturalCommodityDairy2__1 getDairy() {
			return dairy;
		}
		
		@Override
		@RosettaAttribute("frstry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstry")
		public AgriculturalCommodityForestry2__1 getFrstry() {
			return frstry;
		}
		
		@Override
		@RosettaAttribute("sfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sfd")
		public AgriculturalCommoditySeafood2__1 getSfd() {
			return sfd;
		}
		
		@Override
		@RosettaAttribute("liveStock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("liveStock")
		public AgriculturalCommodityLiveStock2__1 getLiveStock() {
			return liveStock;
		}
		
		@Override
		@RosettaAttribute("grn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grn")
		public AgriculturalCommodityGrain3__1 getGrn() {
			return grn;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public AgriculturalCommodityOther2__1 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder toBuilder() {
			AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder builder) {
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
		
			AssetClassCommodityAgricultural6Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityAgricultural6Choice__1 {" +
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

	/*********************** Builder Implementation of AssetClassCommodityAgricultural6Choice__1  ***********************/
	class AssetClassCommodityAgricultural6Choice__1BuilderImpl implements AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder {
	
		protected AgriculturalCommodityOilSeed2__1.AgriculturalCommodityOilSeed2__1Builder grnOilSeed;
		protected AgriculturalCommoditySoft2__1.AgriculturalCommoditySoft2__1Builder soft;
		protected AgriculturalCommodityPotato2__1.AgriculturalCommodityPotato2__1Builder ptt;
		protected AgriculturalCommodityOliveOil3__1.AgriculturalCommodityOliveOil3__1Builder olvOil;
		protected AgriculturalCommodityDairy2__1.AgriculturalCommodityDairy2__1Builder dairy;
		protected AgriculturalCommodityForestry2__1.AgriculturalCommodityForestry2__1Builder frstry;
		protected AgriculturalCommoditySeafood2__1.AgriculturalCommoditySeafood2__1Builder sfd;
		protected AgriculturalCommodityLiveStock2__1.AgriculturalCommodityLiveStock2__1Builder liveStock;
		protected AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder grn;
		protected AgriculturalCommodityOther2__1.AgriculturalCommodityOther2__1Builder othr;
		
		@Override
		@RosettaAttribute("grnOilSeed")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grnOilSeed")
		public AgriculturalCommodityOilSeed2__1.AgriculturalCommodityOilSeed2__1Builder getGrnOilSeed() {
			return grnOilSeed;
		}
		
		@Override
		public AgriculturalCommodityOilSeed2__1.AgriculturalCommodityOilSeed2__1Builder getOrCreateGrnOilSeed() {
			AgriculturalCommodityOilSeed2__1.AgriculturalCommodityOilSeed2__1Builder result;
			if (grnOilSeed!=null) {
				result = grnOilSeed;
			}
			else {
				result = grnOilSeed = AgriculturalCommodityOilSeed2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("soft")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("soft")
		public AgriculturalCommoditySoft2__1.AgriculturalCommoditySoft2__1Builder getSoft() {
			return soft;
		}
		
		@Override
		public AgriculturalCommoditySoft2__1.AgriculturalCommoditySoft2__1Builder getOrCreateSoft() {
			AgriculturalCommoditySoft2__1.AgriculturalCommoditySoft2__1Builder result;
			if (soft!=null) {
				result = soft;
			}
			else {
				result = soft = AgriculturalCommoditySoft2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ptt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptt")
		public AgriculturalCommodityPotato2__1.AgriculturalCommodityPotato2__1Builder getPtt() {
			return ptt;
		}
		
		@Override
		public AgriculturalCommodityPotato2__1.AgriculturalCommodityPotato2__1Builder getOrCreatePtt() {
			AgriculturalCommodityPotato2__1.AgriculturalCommodityPotato2__1Builder result;
			if (ptt!=null) {
				result = ptt;
			}
			else {
				result = ptt = AgriculturalCommodityPotato2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("olvOil")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("olvOil")
		public AgriculturalCommodityOliveOil3__1.AgriculturalCommodityOliveOil3__1Builder getOlvOil() {
			return olvOil;
		}
		
		@Override
		public AgriculturalCommodityOliveOil3__1.AgriculturalCommodityOliveOil3__1Builder getOrCreateOlvOil() {
			AgriculturalCommodityOliveOil3__1.AgriculturalCommodityOliveOil3__1Builder result;
			if (olvOil!=null) {
				result = olvOil;
			}
			else {
				result = olvOil = AgriculturalCommodityOliveOil3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dairy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dairy")
		public AgriculturalCommodityDairy2__1.AgriculturalCommodityDairy2__1Builder getDairy() {
			return dairy;
		}
		
		@Override
		public AgriculturalCommodityDairy2__1.AgriculturalCommodityDairy2__1Builder getOrCreateDairy() {
			AgriculturalCommodityDairy2__1.AgriculturalCommodityDairy2__1Builder result;
			if (dairy!=null) {
				result = dairy;
			}
			else {
				result = dairy = AgriculturalCommodityDairy2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("frstry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstry")
		public AgriculturalCommodityForestry2__1.AgriculturalCommodityForestry2__1Builder getFrstry() {
			return frstry;
		}
		
		@Override
		public AgriculturalCommodityForestry2__1.AgriculturalCommodityForestry2__1Builder getOrCreateFrstry() {
			AgriculturalCommodityForestry2__1.AgriculturalCommodityForestry2__1Builder result;
			if (frstry!=null) {
				result = frstry;
			}
			else {
				result = frstry = AgriculturalCommodityForestry2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sfd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sfd")
		public AgriculturalCommoditySeafood2__1.AgriculturalCommoditySeafood2__1Builder getSfd() {
			return sfd;
		}
		
		@Override
		public AgriculturalCommoditySeafood2__1.AgriculturalCommoditySeafood2__1Builder getOrCreateSfd() {
			AgriculturalCommoditySeafood2__1.AgriculturalCommoditySeafood2__1Builder result;
			if (sfd!=null) {
				result = sfd;
			}
			else {
				result = sfd = AgriculturalCommoditySeafood2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("liveStock")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("liveStock")
		public AgriculturalCommodityLiveStock2__1.AgriculturalCommodityLiveStock2__1Builder getLiveStock() {
			return liveStock;
		}
		
		@Override
		public AgriculturalCommodityLiveStock2__1.AgriculturalCommodityLiveStock2__1Builder getOrCreateLiveStock() {
			AgriculturalCommodityLiveStock2__1.AgriculturalCommodityLiveStock2__1Builder result;
			if (liveStock!=null) {
				result = liveStock;
			}
			else {
				result = liveStock = AgriculturalCommodityLiveStock2__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("grn")
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder getGrn() {
			return grn;
		}
		
		@Override
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder getOrCreateGrn() {
			AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder result;
			if (grn!=null) {
				result = grn;
			}
			else {
				result = grn = AgriculturalCommodityGrain3__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public AgriculturalCommodityOther2__1.AgriculturalCommodityOther2__1Builder getOthr() {
			return othr;
		}
		
		@Override
		public AgriculturalCommodityOther2__1.AgriculturalCommodityOther2__1Builder getOrCreateOthr() {
			AgriculturalCommodityOther2__1.AgriculturalCommodityOther2__1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = AgriculturalCommodityOther2__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("grnOilSeed")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("grnOilSeed")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setGrnOilSeed(AgriculturalCommodityOilSeed2__1 _grnOilSeed) {
			this.grnOilSeed = _grnOilSeed == null ? null : _grnOilSeed.toBuilder();
			return this;
		}
		
		@RosettaAttribute("soft")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("soft")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setSoft(AgriculturalCommoditySoft2__1 _soft) {
			this.soft = _soft == null ? null : _soft.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ptt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptt")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setPtt(AgriculturalCommodityPotato2__1 _ptt) {
			this.ptt = _ptt == null ? null : _ptt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("olvOil")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("olvOil")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setOlvOil(AgriculturalCommodityOliveOil3__1 _olvOil) {
			this.olvOil = _olvOil == null ? null : _olvOil.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dairy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dairy")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setDairy(AgriculturalCommodityDairy2__1 _dairy) {
			this.dairy = _dairy == null ? null : _dairy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("frstry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frstry")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setFrstry(AgriculturalCommodityForestry2__1 _frstry) {
			this.frstry = _frstry == null ? null : _frstry.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sfd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sfd")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setSfd(AgriculturalCommoditySeafood2__1 _sfd) {
			this.sfd = _sfd == null ? null : _sfd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("liveStock")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("liveStock")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setLiveStock(AgriculturalCommodityLiveStock2__1 _liveStock) {
			this.liveStock = _liveStock == null ? null : _liveStock.toBuilder();
			return this;
		}
		
		@RosettaAttribute("grn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("grn")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setGrn(AgriculturalCommodityGrain3__1 _grn) {
			this.grn = _grn == null ? null : _grn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder setOthr(AgriculturalCommodityOther2__1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice__1 build() {
			return new AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder prune() {
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
		public AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder o = (AssetClassCommodityAgricultural6Choice__1.AssetClassCommodityAgricultural6Choice__1Builder) other;
			
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
		
			AssetClassCommodityAgricultural6Choice__1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityAgricultural6Choice__1Builder {" +
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
