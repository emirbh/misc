package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.AssetClassCommodity6Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice to define commodity specific attributes of a derivative.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodity6Choice__1", builder=AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodity6Choice__1", model="iso20022", builder=AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodity6Choice__1 extends RosettaModelObject {

	AssetClassCommodity6Choice__1Meta metaData = new AssetClassCommodity6Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Agricultural commodities.
	 */
	AssetClassCommodityAgricultural6Choice getAgrcltrl();
	/**
	 * Energy commodities.
	 */
	AssetClassCommodityEnergy3Choice getNrgy();
	/**
	 * Environmental commodities.
	 */
	AssetClassCommodityEnvironmental3Choice getEnvttl();
	/**
	 * Fertilizer commodities.
	 */
	AssetClassCommodityFertilizer4Choice getFrtlzr();
	/**
	 * Freight commodities.
	 */
	AssetClassCommodityFreight4Choice getFrght();
	/**
	 * Industrial Product commodities.
	 */
	AssetClassCommodityIndustrialProduct2Choice getIndstrlPdct();
	/**
	 * Inflation commodities.
	 */
	AssetClassCommodityInflation1 getInfltn();
	/**
	 * Metal commodities.
	 */
	AssetClassCommodityMetal2Choice getMetl();
	/**
	 * Multi Commodity Exotic
	 */
	AssetClassCommodityMultiCommodityExotic1 getMultiCmmdtyExtc();
	/**
	 * Official Economic Statistics commodities.
	 */
	AssetClassCommodityOfficialEconomicStatistics1 getOffclEcnmcSttstcs();
	/**
	 * Other commodities.
	 */
	AssetClassCommodityOther1 getOthr();
	/**
	 * Other C10 commodities.
	 */
	AssetClassCommodityC10Other1 getOthrC10();
	/**
	 * Paper commodities.
	 */
	AssetClassCommodityPaper4Choice getPpr();
	/**
	 * Polypropylene commodities.
	 */
	AssetClassCommodityPolypropylene4Choice getPlprpln();

	/*********************** Build Methods  ***********************/
	AssetClassCommodity6Choice__1 build();
	
	AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder toBuilder();
	
	static AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder builder() {
		return new AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodity6Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodity6Choice__1> getType() {
		return AssetClassCommodity6Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("agrcltrl"), processor, AssetClassCommodityAgricultural6Choice.class, getAgrcltrl());
		processRosetta(path.newSubPath("nrgy"), processor, AssetClassCommodityEnergy3Choice.class, getNrgy());
		processRosetta(path.newSubPath("envttl"), processor, AssetClassCommodityEnvironmental3Choice.class, getEnvttl());
		processRosetta(path.newSubPath("frtlzr"), processor, AssetClassCommodityFertilizer4Choice.class, getFrtlzr());
		processRosetta(path.newSubPath("frght"), processor, AssetClassCommodityFreight4Choice.class, getFrght());
		processRosetta(path.newSubPath("indstrlPdct"), processor, AssetClassCommodityIndustrialProduct2Choice.class, getIndstrlPdct());
		processRosetta(path.newSubPath("infltn"), processor, AssetClassCommodityInflation1.class, getInfltn());
		processRosetta(path.newSubPath("metl"), processor, AssetClassCommodityMetal2Choice.class, getMetl());
		processRosetta(path.newSubPath("multiCmmdtyExtc"), processor, AssetClassCommodityMultiCommodityExotic1.class, getMultiCmmdtyExtc());
		processRosetta(path.newSubPath("offclEcnmcSttstcs"), processor, AssetClassCommodityOfficialEconomicStatistics1.class, getOffclEcnmcSttstcs());
		processRosetta(path.newSubPath("othr"), processor, AssetClassCommodityOther1.class, getOthr());
		processRosetta(path.newSubPath("othrC10"), processor, AssetClassCommodityC10Other1.class, getOthrC10());
		processRosetta(path.newSubPath("ppr"), processor, AssetClassCommodityPaper4Choice.class, getPpr());
		processRosetta(path.newSubPath("plprpln"), processor, AssetClassCommodityPolypropylene4Choice.class, getPlprpln());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodity6Choice__1Builder extends AssetClassCommodity6Choice__1, RosettaModelObjectBuilder {
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder getOrCreateAgrcltrl();
		@Override
		AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder getAgrcltrl();
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder getOrCreateNrgy();
		@Override
		AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder getNrgy();
		AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder getOrCreateEnvttl();
		@Override
		AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder getEnvttl();
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder getOrCreateFrtlzr();
		@Override
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder getFrtlzr();
		AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder getOrCreateFrght();
		@Override
		AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder getFrght();
		AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder getOrCreateIndstrlPdct();
		@Override
		AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder getIndstrlPdct();
		AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder getOrCreateInfltn();
		@Override
		AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder getInfltn();
		AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder getOrCreateMetl();
		@Override
		AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder getMetl();
		AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder getOrCreateMultiCmmdtyExtc();
		@Override
		AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder getMultiCmmdtyExtc();
		AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder getOrCreateOffclEcnmcSttstcs();
		@Override
		AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder getOffclEcnmcSttstcs();
		AssetClassCommodityOther1.AssetClassCommodityOther1Builder getOrCreateOthr();
		@Override
		AssetClassCommodityOther1.AssetClassCommodityOther1Builder getOthr();
		AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder getOrCreateOthrC10();
		@Override
		AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder getOthrC10();
		AssetClassCommodityPaper4Choice.AssetClassCommodityPaper4ChoiceBuilder getOrCreatePpr();
		@Override
		AssetClassCommodityPaper4Choice.AssetClassCommodityPaper4ChoiceBuilder getPpr();
		AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder getOrCreatePlprpln();
		@Override
		AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder getPlprpln();
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setAgrcltrl(AssetClassCommodityAgricultural6Choice agrcltrl);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setNrgy(AssetClassCommodityEnergy3Choice nrgy);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setEnvttl(AssetClassCommodityEnvironmental3Choice envttl);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setFrtlzr(AssetClassCommodityFertilizer4Choice frtlzr);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setFrght(AssetClassCommodityFreight4Choice frght);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setIndstrlPdct(AssetClassCommodityIndustrialProduct2Choice indstrlPdct);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setInfltn(AssetClassCommodityInflation1 infltn);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setMetl(AssetClassCommodityMetal2Choice metl);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setMultiCmmdtyExtc(AssetClassCommodityMultiCommodityExotic1 multiCmmdtyExtc);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setOffclEcnmcSttstcs(AssetClassCommodityOfficialEconomicStatistics1 offclEcnmcSttstcs);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setOthr(AssetClassCommodityOther1 othr);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setOthrC10(AssetClassCommodityC10Other1 othrC10);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setPpr(AssetClassCommodityPaper4Choice ppr);
		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setPlprpln(AssetClassCommodityPolypropylene4Choice plprpln);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("agrcltrl"), processor, AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder.class, getAgrcltrl());
			processRosetta(path.newSubPath("nrgy"), processor, AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder.class, getNrgy());
			processRosetta(path.newSubPath("envttl"), processor, AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder.class, getEnvttl());
			processRosetta(path.newSubPath("frtlzr"), processor, AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder.class, getFrtlzr());
			processRosetta(path.newSubPath("frght"), processor, AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder.class, getFrght());
			processRosetta(path.newSubPath("indstrlPdct"), processor, AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder.class, getIndstrlPdct());
			processRosetta(path.newSubPath("infltn"), processor, AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder.class, getInfltn());
			processRosetta(path.newSubPath("metl"), processor, AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder.class, getMetl());
			processRosetta(path.newSubPath("multiCmmdtyExtc"), processor, AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder.class, getMultiCmmdtyExtc());
			processRosetta(path.newSubPath("offclEcnmcSttstcs"), processor, AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder.class, getOffclEcnmcSttstcs());
			processRosetta(path.newSubPath("othr"), processor, AssetClassCommodityOther1.AssetClassCommodityOther1Builder.class, getOthr());
			processRosetta(path.newSubPath("othrC10"), processor, AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder.class, getOthrC10());
			processRosetta(path.newSubPath("ppr"), processor, AssetClassCommodityPaper4Choice.AssetClassCommodityPaper4ChoiceBuilder.class, getPpr());
			processRosetta(path.newSubPath("plprpln"), processor, AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder.class, getPlprpln());
		}
		

		AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodity6Choice__1  ***********************/
	class AssetClassCommodity6Choice__1Impl implements AssetClassCommodity6Choice__1 {
		private final AssetClassCommodityAgricultural6Choice agrcltrl;
		private final AssetClassCommodityEnergy3Choice nrgy;
		private final AssetClassCommodityEnvironmental3Choice envttl;
		private final AssetClassCommodityFertilizer4Choice frtlzr;
		private final AssetClassCommodityFreight4Choice frght;
		private final AssetClassCommodityIndustrialProduct2Choice indstrlPdct;
		private final AssetClassCommodityInflation1 infltn;
		private final AssetClassCommodityMetal2Choice metl;
		private final AssetClassCommodityMultiCommodityExotic1 multiCmmdtyExtc;
		private final AssetClassCommodityOfficialEconomicStatistics1 offclEcnmcSttstcs;
		private final AssetClassCommodityOther1 othr;
		private final AssetClassCommodityC10Other1 othrC10;
		private final AssetClassCommodityPaper4Choice ppr;
		private final AssetClassCommodityPolypropylene4Choice plprpln;
		
		protected AssetClassCommodity6Choice__1Impl(AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder builder) {
			this.agrcltrl = ofNullable(builder.getAgrcltrl()).map(f->f.build()).orElse(null);
			this.nrgy = ofNullable(builder.getNrgy()).map(f->f.build()).orElse(null);
			this.envttl = ofNullable(builder.getEnvttl()).map(f->f.build()).orElse(null);
			this.frtlzr = ofNullable(builder.getFrtlzr()).map(f->f.build()).orElse(null);
			this.frght = ofNullable(builder.getFrght()).map(f->f.build()).orElse(null);
			this.indstrlPdct = ofNullable(builder.getIndstrlPdct()).map(f->f.build()).orElse(null);
			this.infltn = ofNullable(builder.getInfltn()).map(f->f.build()).orElse(null);
			this.metl = ofNullable(builder.getMetl()).map(f->f.build()).orElse(null);
			this.multiCmmdtyExtc = ofNullable(builder.getMultiCmmdtyExtc()).map(f->f.build()).orElse(null);
			this.offclEcnmcSttstcs = ofNullable(builder.getOffclEcnmcSttstcs()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
			this.othrC10 = ofNullable(builder.getOthrC10()).map(f->f.build()).orElse(null);
			this.ppr = ofNullable(builder.getPpr()).map(f->f.build()).orElse(null);
			this.plprpln = ofNullable(builder.getPlprpln()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("agrcltrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agrcltrl")
		public AssetClassCommodityAgricultural6Choice getAgrcltrl() {
			return agrcltrl;
		}
		
		@Override
		@RosettaAttribute("nrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nrgy")
		public AssetClassCommodityEnergy3Choice getNrgy() {
			return nrgy;
		}
		
		@Override
		@RosettaAttribute("envttl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("envttl")
		public AssetClassCommodityEnvironmental3Choice getEnvttl() {
			return envttl;
		}
		
		@Override
		@RosettaAttribute("frtlzr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frtlzr")
		public AssetClassCommodityFertilizer4Choice getFrtlzr() {
			return frtlzr;
		}
		
		@Override
		@RosettaAttribute("frght")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frght")
		public AssetClassCommodityFreight4Choice getFrght() {
			return frght;
		}
		
		@Override
		@RosettaAttribute("indstrlPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indstrlPdct")
		public AssetClassCommodityIndustrialProduct2Choice getIndstrlPdct() {
			return indstrlPdct;
		}
		
		@Override
		@RosettaAttribute("infltn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("infltn")
		public AssetClassCommodityInflation1 getInfltn() {
			return infltn;
		}
		
		@Override
		@RosettaAttribute("metl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metl")
		public AssetClassCommodityMetal2Choice getMetl() {
			return metl;
		}
		
		@Override
		@RosettaAttribute("multiCmmdtyExtc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiCmmdtyExtc")
		public AssetClassCommodityMultiCommodityExotic1 getMultiCmmdtyExtc() {
			return multiCmmdtyExtc;
		}
		
		@Override
		@RosettaAttribute("offclEcnmcSttstcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offclEcnmcSttstcs")
		public AssetClassCommodityOfficialEconomicStatistics1 getOffclEcnmcSttstcs() {
			return offclEcnmcSttstcs;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public AssetClassCommodityOther1 getOthr() {
			return othr;
		}
		
		@Override
		@RosettaAttribute("othrC10")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othrC10")
		public AssetClassCommodityC10Other1 getOthrC10() {
			return othrC10;
		}
		
		@Override
		@RosettaAttribute("ppr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ppr")
		public AssetClassCommodityPaper4Choice getPpr() {
			return ppr;
		}
		
		@Override
		@RosettaAttribute("plprpln")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plprpln")
		public AssetClassCommodityPolypropylene4Choice getPlprpln() {
			return plprpln;
		}
		
		@Override
		public AssetClassCommodity6Choice__1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder toBuilder() {
			AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder builder) {
			ofNullable(getAgrcltrl()).ifPresent(builder::setAgrcltrl);
			ofNullable(getNrgy()).ifPresent(builder::setNrgy);
			ofNullable(getEnvttl()).ifPresent(builder::setEnvttl);
			ofNullable(getFrtlzr()).ifPresent(builder::setFrtlzr);
			ofNullable(getFrght()).ifPresent(builder::setFrght);
			ofNullable(getIndstrlPdct()).ifPresent(builder::setIndstrlPdct);
			ofNullable(getInfltn()).ifPresent(builder::setInfltn);
			ofNullable(getMetl()).ifPresent(builder::setMetl);
			ofNullable(getMultiCmmdtyExtc()).ifPresent(builder::setMultiCmmdtyExtc);
			ofNullable(getOffclEcnmcSttstcs()).ifPresent(builder::setOffclEcnmcSttstcs);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
			ofNullable(getOthrC10()).ifPresent(builder::setOthrC10);
			ofNullable(getPpr()).ifPresent(builder::setPpr);
			ofNullable(getPlprpln()).ifPresent(builder::setPlprpln);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodity6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(agrcltrl, _that.getAgrcltrl())) return false;
			if (!Objects.equals(nrgy, _that.getNrgy())) return false;
			if (!Objects.equals(envttl, _that.getEnvttl())) return false;
			if (!Objects.equals(frtlzr, _that.getFrtlzr())) return false;
			if (!Objects.equals(frght, _that.getFrght())) return false;
			if (!Objects.equals(indstrlPdct, _that.getIndstrlPdct())) return false;
			if (!Objects.equals(infltn, _that.getInfltn())) return false;
			if (!Objects.equals(metl, _that.getMetl())) return false;
			if (!Objects.equals(multiCmmdtyExtc, _that.getMultiCmmdtyExtc())) return false;
			if (!Objects.equals(offclEcnmcSttstcs, _that.getOffclEcnmcSttstcs())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			if (!Objects.equals(othrC10, _that.getOthrC10())) return false;
			if (!Objects.equals(ppr, _that.getPpr())) return false;
			if (!Objects.equals(plprpln, _that.getPlprpln())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agrcltrl != null ? agrcltrl.hashCode() : 0);
			_result = 31 * _result + (nrgy != null ? nrgy.hashCode() : 0);
			_result = 31 * _result + (envttl != null ? envttl.hashCode() : 0);
			_result = 31 * _result + (frtlzr != null ? frtlzr.hashCode() : 0);
			_result = 31 * _result + (frght != null ? frght.hashCode() : 0);
			_result = 31 * _result + (indstrlPdct != null ? indstrlPdct.hashCode() : 0);
			_result = 31 * _result + (infltn != null ? infltn.hashCode() : 0);
			_result = 31 * _result + (metl != null ? metl.hashCode() : 0);
			_result = 31 * _result + (multiCmmdtyExtc != null ? multiCmmdtyExtc.hashCode() : 0);
			_result = 31 * _result + (offclEcnmcSttstcs != null ? offclEcnmcSttstcs.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			_result = 31 * _result + (othrC10 != null ? othrC10.hashCode() : 0);
			_result = 31 * _result + (ppr != null ? ppr.hashCode() : 0);
			_result = 31 * _result + (plprpln != null ? plprpln.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodity6Choice__1 {" +
				"agrcltrl=" + this.agrcltrl + ", " +
				"nrgy=" + this.nrgy + ", " +
				"envttl=" + this.envttl + ", " +
				"frtlzr=" + this.frtlzr + ", " +
				"frght=" + this.frght + ", " +
				"indstrlPdct=" + this.indstrlPdct + ", " +
				"infltn=" + this.infltn + ", " +
				"metl=" + this.metl + ", " +
				"multiCmmdtyExtc=" + this.multiCmmdtyExtc + ", " +
				"offclEcnmcSttstcs=" + this.offclEcnmcSttstcs + ", " +
				"othr=" + this.othr + ", " +
				"othrC10=" + this.othrC10 + ", " +
				"ppr=" + this.ppr + ", " +
				"plprpln=" + this.plprpln +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodity6Choice__1  ***********************/
	class AssetClassCommodity6Choice__1BuilderImpl implements AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder {
	
		protected AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder agrcltrl;
		protected AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder nrgy;
		protected AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder envttl;
		protected AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder frtlzr;
		protected AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder frght;
		protected AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder indstrlPdct;
		protected AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder infltn;
		protected AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder metl;
		protected AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder multiCmmdtyExtc;
		protected AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder offclEcnmcSttstcs;
		protected AssetClassCommodityOther1.AssetClassCommodityOther1Builder othr;
		protected AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder othrC10;
		protected AssetClassCommodityPaper4Choice.AssetClassCommodityPaper4ChoiceBuilder ppr;
		protected AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder plprpln;
		
		@Override
		@RosettaAttribute("agrcltrl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("agrcltrl")
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder getAgrcltrl() {
			return agrcltrl;
		}
		
		@Override
		public AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder getOrCreateAgrcltrl() {
			AssetClassCommodityAgricultural6Choice.AssetClassCommodityAgricultural6ChoiceBuilder result;
			if (agrcltrl!=null) {
				result = agrcltrl;
			}
			else {
				result = agrcltrl = AssetClassCommodityAgricultural6Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("nrgy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("nrgy")
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder getNrgy() {
			return nrgy;
		}
		
		@Override
		public AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder getOrCreateNrgy() {
			AssetClassCommodityEnergy3Choice.AssetClassCommodityEnergy3ChoiceBuilder result;
			if (nrgy!=null) {
				result = nrgy;
			}
			else {
				result = nrgy = AssetClassCommodityEnergy3Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("envttl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("envttl")
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder getEnvttl() {
			return envttl;
		}
		
		@Override
		public AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder getOrCreateEnvttl() {
			AssetClassCommodityEnvironmental3Choice.AssetClassCommodityEnvironmental3ChoiceBuilder result;
			if (envttl!=null) {
				result = envttl;
			}
			else {
				result = envttl = AssetClassCommodityEnvironmental3Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("frtlzr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frtlzr")
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder getFrtlzr() {
			return frtlzr;
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder getOrCreateFrtlzr() {
			AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder result;
			if (frtlzr!=null) {
				result = frtlzr;
			}
			else {
				result = frtlzr = AssetClassCommodityFertilizer4Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("frght")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frght")
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder getFrght() {
			return frght;
		}
		
		@Override
		public AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder getOrCreateFrght() {
			AssetClassCommodityFreight4Choice.AssetClassCommodityFreight4ChoiceBuilder result;
			if (frght!=null) {
				result = frght;
			}
			else {
				result = frght = AssetClassCommodityFreight4Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indstrlPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indstrlPdct")
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder getIndstrlPdct() {
			return indstrlPdct;
		}
		
		@Override
		public AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder getOrCreateIndstrlPdct() {
			AssetClassCommodityIndustrialProduct2Choice.AssetClassCommodityIndustrialProduct2ChoiceBuilder result;
			if (indstrlPdct!=null) {
				result = indstrlPdct;
			}
			else {
				result = indstrlPdct = AssetClassCommodityIndustrialProduct2Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("infltn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("infltn")
		public AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder getInfltn() {
			return infltn;
		}
		
		@Override
		public AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder getOrCreateInfltn() {
			AssetClassCommodityInflation1.AssetClassCommodityInflation1Builder result;
			if (infltn!=null) {
				result = infltn;
			}
			else {
				result = infltn = AssetClassCommodityInflation1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("metl")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("metl")
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder getMetl() {
			return metl;
		}
		
		@Override
		public AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder getOrCreateMetl() {
			AssetClassCommodityMetal2Choice.AssetClassCommodityMetal2ChoiceBuilder result;
			if (metl!=null) {
				result = metl;
			}
			else {
				result = metl = AssetClassCommodityMetal2Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiCmmdtyExtc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("multiCmmdtyExtc")
		public AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder getMultiCmmdtyExtc() {
			return multiCmmdtyExtc;
		}
		
		@Override
		public AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder getOrCreateMultiCmmdtyExtc() {
			AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder result;
			if (multiCmmdtyExtc!=null) {
				result = multiCmmdtyExtc;
			}
			else {
				result = multiCmmdtyExtc = AssetClassCommodityMultiCommodityExotic1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("offclEcnmcSttstcs")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("offclEcnmcSttstcs")
		public AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder getOffclEcnmcSttstcs() {
			return offclEcnmcSttstcs;
		}
		
		@Override
		public AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder getOrCreateOffclEcnmcSttstcs() {
			AssetClassCommodityOfficialEconomicStatistics1.AssetClassCommodityOfficialEconomicStatistics1Builder result;
			if (offclEcnmcSttstcs!=null) {
				result = offclEcnmcSttstcs;
			}
			else {
				result = offclEcnmcSttstcs = AssetClassCommodityOfficialEconomicStatistics1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public AssetClassCommodityOther1.AssetClassCommodityOther1Builder getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityOther1.AssetClassCommodityOther1Builder getOrCreateOthr() {
			AssetClassCommodityOther1.AssetClassCommodityOther1Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = AssetClassCommodityOther1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othrC10")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othrC10")
		public AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder getOthrC10() {
			return othrC10;
		}
		
		@Override
		public AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder getOrCreateOthrC10() {
			AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder result;
			if (othrC10!=null) {
				result = othrC10;
			}
			else {
				result = othrC10 = AssetClassCommodityC10Other1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ppr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ppr")
		public AssetClassCommodityPaper4Choice.AssetClassCommodityPaper4ChoiceBuilder getPpr() {
			return ppr;
		}
		
		@Override
		public AssetClassCommodityPaper4Choice.AssetClassCommodityPaper4ChoiceBuilder getOrCreatePpr() {
			AssetClassCommodityPaper4Choice.AssetClassCommodityPaper4ChoiceBuilder result;
			if (ppr!=null) {
				result = ppr;
			}
			else {
				result = ppr = AssetClassCommodityPaper4Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("plprpln")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plprpln")
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder getPlprpln() {
			return plprpln;
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder getOrCreatePlprpln() {
			AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder result;
			if (plprpln!=null) {
				result = plprpln;
			}
			else {
				result = plprpln = AssetClassCommodityPolypropylene4Choice.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("agrcltrl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("agrcltrl")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setAgrcltrl(AssetClassCommodityAgricultural6Choice _agrcltrl) {
			this.agrcltrl = _agrcltrl == null ? null : _agrcltrl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("nrgy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("nrgy")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setNrgy(AssetClassCommodityEnergy3Choice _nrgy) {
			this.nrgy = _nrgy == null ? null : _nrgy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("envttl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("envttl")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setEnvttl(AssetClassCommodityEnvironmental3Choice _envttl) {
			this.envttl = _envttl == null ? null : _envttl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("frtlzr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frtlzr")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setFrtlzr(AssetClassCommodityFertilizer4Choice _frtlzr) {
			this.frtlzr = _frtlzr == null ? null : _frtlzr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("frght")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frght")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setFrght(AssetClassCommodityFreight4Choice _frght) {
			this.frght = _frght == null ? null : _frght.toBuilder();
			return this;
		}
		
		@RosettaAttribute("indstrlPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indstrlPdct")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setIndstrlPdct(AssetClassCommodityIndustrialProduct2Choice _indstrlPdct) {
			this.indstrlPdct = _indstrlPdct == null ? null : _indstrlPdct.toBuilder();
			return this;
		}
		
		@RosettaAttribute("infltn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("infltn")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setInfltn(AssetClassCommodityInflation1 _infltn) {
			this.infltn = _infltn == null ? null : _infltn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("metl")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("metl")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setMetl(AssetClassCommodityMetal2Choice _metl) {
			this.metl = _metl == null ? null : _metl.toBuilder();
			return this;
		}
		
		@RosettaAttribute("multiCmmdtyExtc")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("multiCmmdtyExtc")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setMultiCmmdtyExtc(AssetClassCommodityMultiCommodityExotic1 _multiCmmdtyExtc) {
			this.multiCmmdtyExtc = _multiCmmdtyExtc == null ? null : _multiCmmdtyExtc.toBuilder();
			return this;
		}
		
		@RosettaAttribute("offclEcnmcSttstcs")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("offclEcnmcSttstcs")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setOffclEcnmcSttstcs(AssetClassCommodityOfficialEconomicStatistics1 _offclEcnmcSttstcs) {
			this.offclEcnmcSttstcs = _offclEcnmcSttstcs == null ? null : _offclEcnmcSttstcs.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setOthr(AssetClassCommodityOther1 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othrC10")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othrC10")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setOthrC10(AssetClassCommodityC10Other1 _othrC10) {
			this.othrC10 = _othrC10 == null ? null : _othrC10.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ppr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ppr")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setPpr(AssetClassCommodityPaper4Choice _ppr) {
			this.ppr = _ppr == null ? null : _ppr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("plprpln")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("plprpln")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder setPlprpln(AssetClassCommodityPolypropylene4Choice _plprpln) {
			this.plprpln = _plprpln == null ? null : _plprpln.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodity6Choice__1 build() {
			return new AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Impl(this);
		}
		
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder prune() {
			if (agrcltrl!=null && !agrcltrl.prune().hasData()) agrcltrl = null;
			if (nrgy!=null && !nrgy.prune().hasData()) nrgy = null;
			if (envttl!=null && !envttl.prune().hasData()) envttl = null;
			if (frtlzr!=null && !frtlzr.prune().hasData()) frtlzr = null;
			if (frght!=null && !frght.prune().hasData()) frght = null;
			if (indstrlPdct!=null && !indstrlPdct.prune().hasData()) indstrlPdct = null;
			if (infltn!=null && !infltn.prune().hasData()) infltn = null;
			if (metl!=null && !metl.prune().hasData()) metl = null;
			if (multiCmmdtyExtc!=null && !multiCmmdtyExtc.prune().hasData()) multiCmmdtyExtc = null;
			if (offclEcnmcSttstcs!=null && !offclEcnmcSttstcs.prune().hasData()) offclEcnmcSttstcs = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			if (othrC10!=null && !othrC10.prune().hasData()) othrC10 = null;
			if (ppr!=null && !ppr.prune().hasData()) ppr = null;
			if (plprpln!=null && !plprpln.prune().hasData()) plprpln = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgrcltrl()!=null && getAgrcltrl().hasData()) return true;
			if (getNrgy()!=null && getNrgy().hasData()) return true;
			if (getEnvttl()!=null && getEnvttl().hasData()) return true;
			if (getFrtlzr()!=null && getFrtlzr().hasData()) return true;
			if (getFrght()!=null && getFrght().hasData()) return true;
			if (getIndstrlPdct()!=null && getIndstrlPdct().hasData()) return true;
			if (getInfltn()!=null && getInfltn().hasData()) return true;
			if (getMetl()!=null && getMetl().hasData()) return true;
			if (getMultiCmmdtyExtc()!=null && getMultiCmmdtyExtc().hasData()) return true;
			if (getOffclEcnmcSttstcs()!=null && getOffclEcnmcSttstcs().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			if (getOthrC10()!=null && getOthrC10().hasData()) return true;
			if (getPpr()!=null && getPpr().hasData()) return true;
			if (getPlprpln()!=null && getPlprpln().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder o = (AssetClassCommodity6Choice__1.AssetClassCommodity6Choice__1Builder) other;
			
			merger.mergeRosetta(getAgrcltrl(), o.getAgrcltrl(), this::setAgrcltrl);
			merger.mergeRosetta(getNrgy(), o.getNrgy(), this::setNrgy);
			merger.mergeRosetta(getEnvttl(), o.getEnvttl(), this::setEnvttl);
			merger.mergeRosetta(getFrtlzr(), o.getFrtlzr(), this::setFrtlzr);
			merger.mergeRosetta(getFrght(), o.getFrght(), this::setFrght);
			merger.mergeRosetta(getIndstrlPdct(), o.getIndstrlPdct(), this::setIndstrlPdct);
			merger.mergeRosetta(getInfltn(), o.getInfltn(), this::setInfltn);
			merger.mergeRosetta(getMetl(), o.getMetl(), this::setMetl);
			merger.mergeRosetta(getMultiCmmdtyExtc(), o.getMultiCmmdtyExtc(), this::setMultiCmmdtyExtc);
			merger.mergeRosetta(getOffclEcnmcSttstcs(), o.getOffclEcnmcSttstcs(), this::setOffclEcnmcSttstcs);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			merger.mergeRosetta(getOthrC10(), o.getOthrC10(), this::setOthrC10);
			merger.mergeRosetta(getPpr(), o.getPpr(), this::setPpr);
			merger.mergeRosetta(getPlprpln(), o.getPlprpln(), this::setPlprpln);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodity6Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(agrcltrl, _that.getAgrcltrl())) return false;
			if (!Objects.equals(nrgy, _that.getNrgy())) return false;
			if (!Objects.equals(envttl, _that.getEnvttl())) return false;
			if (!Objects.equals(frtlzr, _that.getFrtlzr())) return false;
			if (!Objects.equals(frght, _that.getFrght())) return false;
			if (!Objects.equals(indstrlPdct, _that.getIndstrlPdct())) return false;
			if (!Objects.equals(infltn, _that.getInfltn())) return false;
			if (!Objects.equals(metl, _that.getMetl())) return false;
			if (!Objects.equals(multiCmmdtyExtc, _that.getMultiCmmdtyExtc())) return false;
			if (!Objects.equals(offclEcnmcSttstcs, _that.getOffclEcnmcSttstcs())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			if (!Objects.equals(othrC10, _that.getOthrC10())) return false;
			if (!Objects.equals(ppr, _that.getPpr())) return false;
			if (!Objects.equals(plprpln, _that.getPlprpln())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agrcltrl != null ? agrcltrl.hashCode() : 0);
			_result = 31 * _result + (nrgy != null ? nrgy.hashCode() : 0);
			_result = 31 * _result + (envttl != null ? envttl.hashCode() : 0);
			_result = 31 * _result + (frtlzr != null ? frtlzr.hashCode() : 0);
			_result = 31 * _result + (frght != null ? frght.hashCode() : 0);
			_result = 31 * _result + (indstrlPdct != null ? indstrlPdct.hashCode() : 0);
			_result = 31 * _result + (infltn != null ? infltn.hashCode() : 0);
			_result = 31 * _result + (metl != null ? metl.hashCode() : 0);
			_result = 31 * _result + (multiCmmdtyExtc != null ? multiCmmdtyExtc.hashCode() : 0);
			_result = 31 * _result + (offclEcnmcSttstcs != null ? offclEcnmcSttstcs.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			_result = 31 * _result + (othrC10 != null ? othrC10.hashCode() : 0);
			_result = 31 * _result + (ppr != null ? ppr.hashCode() : 0);
			_result = 31 * _result + (plprpln != null ? plprpln.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodity6Choice__1Builder {" +
				"agrcltrl=" + this.agrcltrl + ", " +
				"nrgy=" + this.nrgy + ", " +
				"envttl=" + this.envttl + ", " +
				"frtlzr=" + this.frtlzr + ", " +
				"frght=" + this.frght + ", " +
				"indstrlPdct=" + this.indstrlPdct + ", " +
				"infltn=" + this.infltn + ", " +
				"metl=" + this.metl + ", " +
				"multiCmmdtyExtc=" + this.multiCmmdtyExtc + ", " +
				"offclEcnmcSttstcs=" + this.offclEcnmcSttstcs + ", " +
				"othr=" + this.othr + ", " +
				"othrC10=" + this.othrC10 + ", " +
				"ppr=" + this.ppr + ", " +
				"plprpln=" + this.plprpln +
			'}';
		}
	}
}
