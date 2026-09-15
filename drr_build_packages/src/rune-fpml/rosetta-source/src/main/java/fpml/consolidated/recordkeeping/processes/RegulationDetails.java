package fpml.consolidated.recordkeeping.processes;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.recordkeeping.processes.meta.RegulationDetailsMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision  DEPRECATED. Not in use (RPTWG decision 2024-12-12).
 *
 */
@RosettaDataType(value="RegulationDetails", builder=RegulationDetails.RegulationDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulationDetails", model="fpml", builder=RegulationDetails.RegulationDetailsBuilderImpl.class, version="2.1.1")
public interface RegulationDetails extends RosettaModelObject {

	RegulationDetailsMeta metaData = new RegulationDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationPart43_2012 getCftc_part43_2012();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationPart43_2019 getCftc_part43_2019();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationPart45_2012 getCftc_part45_2012();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationPart45_2019 getCftc_part45_2019();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationEMIR_2015 getEsma_emirRts_2015();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationMifirRTS6a_2015 getEsma_mifirRts6a_2015();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationMifirRTS6b_2015 getEsma_mifirRts6b_2015();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationMifirRTS22_2015 getEsma_mifirRts22_2015();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationMifirRTS23_2015 getEsma_mifirRts23_2015();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationMifirRTS24_2015 getEsma_mifirRts24_2015();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationCSA_2016 getCsa_derivativesReporting_2016();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationMAS_2013 getMas_sfa_2013();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationASIC_2013 getAsic_derivativesTransactionRules_2013();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	RegulatoryClassificationSFTR_2019 getEsma_sftrRts_2019();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Not in use (RPTWG decision 2024-12-12).
	 *
	 */
	List<? extends RegulatoryClassificationOther> getOther();

	/*********************** Build Methods  ***********************/
	RegulationDetails build();
	
	RegulationDetails.RegulationDetailsBuilder toBuilder();
	
	static RegulationDetails.RegulationDetailsBuilder builder() {
		return new RegulationDetails.RegulationDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulationDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulationDetails> getType() {
		return RegulationDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("cftc_part43_2012"), processor, RegulatoryClassificationPart43_2012.class, getCftc_part43_2012());
		processRosetta(path.newSubPath("cftc_part43_2019"), processor, RegulatoryClassificationPart43_2019.class, getCftc_part43_2019());
		processRosetta(path.newSubPath("cftc_part45_2012"), processor, RegulatoryClassificationPart45_2012.class, getCftc_part45_2012());
		processRosetta(path.newSubPath("cftc_part45_2019"), processor, RegulatoryClassificationPart45_2019.class, getCftc_part45_2019());
		processRosetta(path.newSubPath("esma_emirRts_2015"), processor, RegulatoryClassificationEMIR_2015.class, getEsma_emirRts_2015());
		processRosetta(path.newSubPath("esma_mifirRts6a_2015"), processor, RegulatoryClassificationMifirRTS6a_2015.class, getEsma_mifirRts6a_2015());
		processRosetta(path.newSubPath("esma_mifirRts6b_2015"), processor, RegulatoryClassificationMifirRTS6b_2015.class, getEsma_mifirRts6b_2015());
		processRosetta(path.newSubPath("esma_mifirRts22_2015"), processor, RegulatoryClassificationMifirRTS22_2015.class, getEsma_mifirRts22_2015());
		processRosetta(path.newSubPath("esma_mifirRts23_2015"), processor, RegulatoryClassificationMifirRTS23_2015.class, getEsma_mifirRts23_2015());
		processRosetta(path.newSubPath("esma_mifirRts24_2015"), processor, RegulatoryClassificationMifirRTS24_2015.class, getEsma_mifirRts24_2015());
		processRosetta(path.newSubPath("csa_derivativesReporting_2016"), processor, RegulatoryClassificationCSA_2016.class, getCsa_derivativesReporting_2016());
		processRosetta(path.newSubPath("mas_sfa_2013"), processor, RegulatoryClassificationMAS_2013.class, getMas_sfa_2013());
		processRosetta(path.newSubPath("asic_derivativesTransactionRules_2013"), processor, RegulatoryClassificationASIC_2013.class, getAsic_derivativesTransactionRules_2013());
		processRosetta(path.newSubPath("esma_sftrRts_2019"), processor, RegulatoryClassificationSFTR_2019.class, getEsma_sftrRts_2019());
		processRosetta(path.newSubPath("other"), processor, RegulatoryClassificationOther.class, getOther());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulationDetailsBuilder extends RegulationDetails, RosettaModelObjectBuilder {
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder getOrCreateCftc_part43_2012();
		@Override
		RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder getCftc_part43_2012();
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder getOrCreateCftc_part43_2019();
		@Override
		RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder getCftc_part43_2019();
		RegulatoryClassificationPart45_2012.RegulatoryClassificationPart45_2012Builder getOrCreateCftc_part45_2012();
		@Override
		RegulatoryClassificationPart45_2012.RegulatoryClassificationPart45_2012Builder getCftc_part45_2012();
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder getOrCreateCftc_part45_2019();
		@Override
		RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder getCftc_part45_2019();
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder getOrCreateEsma_emirRts_2015();
		@Override
		RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder getEsma_emirRts_2015();
		RegulatoryClassificationMifirRTS6a_2015.RegulatoryClassificationMifirRTS6a_2015Builder getOrCreateEsma_mifirRts6a_2015();
		@Override
		RegulatoryClassificationMifirRTS6a_2015.RegulatoryClassificationMifirRTS6a_2015Builder getEsma_mifirRts6a_2015();
		RegulatoryClassificationMifirRTS6b_2015.RegulatoryClassificationMifirRTS6b_2015Builder getOrCreateEsma_mifirRts6b_2015();
		@Override
		RegulatoryClassificationMifirRTS6b_2015.RegulatoryClassificationMifirRTS6b_2015Builder getEsma_mifirRts6b_2015();
		RegulatoryClassificationMifirRTS22_2015.RegulatoryClassificationMifirRTS22_2015Builder getOrCreateEsma_mifirRts22_2015();
		@Override
		RegulatoryClassificationMifirRTS22_2015.RegulatoryClassificationMifirRTS22_2015Builder getEsma_mifirRts22_2015();
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder getOrCreateEsma_mifirRts23_2015();
		@Override
		RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder getEsma_mifirRts23_2015();
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder getOrCreateEsma_mifirRts24_2015();
		@Override
		RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder getEsma_mifirRts24_2015();
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder getOrCreateCsa_derivativesReporting_2016();
		@Override
		RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder getCsa_derivativesReporting_2016();
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder getOrCreateMas_sfa_2013();
		@Override
		RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder getMas_sfa_2013();
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder getOrCreateAsic_derivativesTransactionRules_2013();
		@Override
		RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder getAsic_derivativesTransactionRules_2013();
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder getOrCreateEsma_sftrRts_2019();
		@Override
		RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder getEsma_sftrRts_2019();
		RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder getOrCreateOther(int index);
		@Override
		List<? extends RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder> getOther();
		RegulationDetails.RegulationDetailsBuilder setCftc_part43_2012(RegulatoryClassificationPart43_2012 cftc_part43_2012);
		RegulationDetails.RegulationDetailsBuilder setCftc_part43_2019(RegulatoryClassificationPart43_2019 cftc_part43_2019);
		RegulationDetails.RegulationDetailsBuilder setCftc_part45_2012(RegulatoryClassificationPart45_2012 cftc_part45_2012);
		RegulationDetails.RegulationDetailsBuilder setCftc_part45_2019(RegulatoryClassificationPart45_2019 cftc_part45_2019);
		RegulationDetails.RegulationDetailsBuilder setEsma_emirRts_2015(RegulatoryClassificationEMIR_2015 esma_emirRts_2015);
		RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts6a_2015(RegulatoryClassificationMifirRTS6a_2015 esma_mifirRts6a_2015);
		RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts6b_2015(RegulatoryClassificationMifirRTS6b_2015 esma_mifirRts6b_2015);
		RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts22_2015(RegulatoryClassificationMifirRTS22_2015 esma_mifirRts22_2015);
		RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts23_2015(RegulatoryClassificationMifirRTS23_2015 esma_mifirRts23_2015);
		RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts24_2015(RegulatoryClassificationMifirRTS24_2015 esma_mifirRts24_2015);
		RegulationDetails.RegulationDetailsBuilder setCsa_derivativesReporting_2016(RegulatoryClassificationCSA_2016 csa_derivativesReporting_2016);
		RegulationDetails.RegulationDetailsBuilder setMas_sfa_2013(RegulatoryClassificationMAS_2013 mas_sfa_2013);
		RegulationDetails.RegulationDetailsBuilder setAsic_derivativesTransactionRules_2013(RegulatoryClassificationASIC_2013 asic_derivativesTransactionRules_2013);
		RegulationDetails.RegulationDetailsBuilder setEsma_sftrRts_2019(RegulatoryClassificationSFTR_2019 esma_sftrRts_2019);
		RegulationDetails.RegulationDetailsBuilder addOther(RegulatoryClassificationOther other);
		RegulationDetails.RegulationDetailsBuilder addOther(RegulatoryClassificationOther other, int idx);
		RegulationDetails.RegulationDetailsBuilder addOther(List<? extends RegulatoryClassificationOther> other);
		RegulationDetails.RegulationDetailsBuilder setOther(List<? extends RegulatoryClassificationOther> other);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("cftc_part43_2012"), processor, RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder.class, getCftc_part43_2012());
			processRosetta(path.newSubPath("cftc_part43_2019"), processor, RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder.class, getCftc_part43_2019());
			processRosetta(path.newSubPath("cftc_part45_2012"), processor, RegulatoryClassificationPart45_2012.RegulatoryClassificationPart45_2012Builder.class, getCftc_part45_2012());
			processRosetta(path.newSubPath("cftc_part45_2019"), processor, RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder.class, getCftc_part45_2019());
			processRosetta(path.newSubPath("esma_emirRts_2015"), processor, RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder.class, getEsma_emirRts_2015());
			processRosetta(path.newSubPath("esma_mifirRts6a_2015"), processor, RegulatoryClassificationMifirRTS6a_2015.RegulatoryClassificationMifirRTS6a_2015Builder.class, getEsma_mifirRts6a_2015());
			processRosetta(path.newSubPath("esma_mifirRts6b_2015"), processor, RegulatoryClassificationMifirRTS6b_2015.RegulatoryClassificationMifirRTS6b_2015Builder.class, getEsma_mifirRts6b_2015());
			processRosetta(path.newSubPath("esma_mifirRts22_2015"), processor, RegulatoryClassificationMifirRTS22_2015.RegulatoryClassificationMifirRTS22_2015Builder.class, getEsma_mifirRts22_2015());
			processRosetta(path.newSubPath("esma_mifirRts23_2015"), processor, RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder.class, getEsma_mifirRts23_2015());
			processRosetta(path.newSubPath("esma_mifirRts24_2015"), processor, RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder.class, getEsma_mifirRts24_2015());
			processRosetta(path.newSubPath("csa_derivativesReporting_2016"), processor, RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder.class, getCsa_derivativesReporting_2016());
			processRosetta(path.newSubPath("mas_sfa_2013"), processor, RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder.class, getMas_sfa_2013());
			processRosetta(path.newSubPath("asic_derivativesTransactionRules_2013"), processor, RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder.class, getAsic_derivativesTransactionRules_2013());
			processRosetta(path.newSubPath("esma_sftrRts_2019"), processor, RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder.class, getEsma_sftrRts_2019());
			processRosetta(path.newSubPath("other"), processor, RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder.class, getOther());
		}
		

		RegulationDetails.RegulationDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulationDetails  ***********************/
	class RegulationDetailsImpl implements RegulationDetails {
		private final RegulatoryClassificationPart43_2012 cftc_part43_2012;
		private final RegulatoryClassificationPart43_2019 cftc_part43_2019;
		private final RegulatoryClassificationPart45_2012 cftc_part45_2012;
		private final RegulatoryClassificationPart45_2019 cftc_part45_2019;
		private final RegulatoryClassificationEMIR_2015 esma_emirRts_2015;
		private final RegulatoryClassificationMifirRTS6a_2015 esma_mifirRts6a_2015;
		private final RegulatoryClassificationMifirRTS6b_2015 esma_mifirRts6b_2015;
		private final RegulatoryClassificationMifirRTS22_2015 esma_mifirRts22_2015;
		private final RegulatoryClassificationMifirRTS23_2015 esma_mifirRts23_2015;
		private final RegulatoryClassificationMifirRTS24_2015 esma_mifirRts24_2015;
		private final RegulatoryClassificationCSA_2016 csa_derivativesReporting_2016;
		private final RegulatoryClassificationMAS_2013 mas_sfa_2013;
		private final RegulatoryClassificationASIC_2013 asic_derivativesTransactionRules_2013;
		private final RegulatoryClassificationSFTR_2019 esma_sftrRts_2019;
		private final List<? extends RegulatoryClassificationOther> other;
		
		protected RegulationDetailsImpl(RegulationDetails.RegulationDetailsBuilder builder) {
			this.cftc_part43_2012 = ofNullable(builder.getCftc_part43_2012()).map(f->f.build()).orElse(null);
			this.cftc_part43_2019 = ofNullable(builder.getCftc_part43_2019()).map(f->f.build()).orElse(null);
			this.cftc_part45_2012 = ofNullable(builder.getCftc_part45_2012()).map(f->f.build()).orElse(null);
			this.cftc_part45_2019 = ofNullable(builder.getCftc_part45_2019()).map(f->f.build()).orElse(null);
			this.esma_emirRts_2015 = ofNullable(builder.getEsma_emirRts_2015()).map(f->f.build()).orElse(null);
			this.esma_mifirRts6a_2015 = ofNullable(builder.getEsma_mifirRts6a_2015()).map(f->f.build()).orElse(null);
			this.esma_mifirRts6b_2015 = ofNullable(builder.getEsma_mifirRts6b_2015()).map(f->f.build()).orElse(null);
			this.esma_mifirRts22_2015 = ofNullable(builder.getEsma_mifirRts22_2015()).map(f->f.build()).orElse(null);
			this.esma_mifirRts23_2015 = ofNullable(builder.getEsma_mifirRts23_2015()).map(f->f.build()).orElse(null);
			this.esma_mifirRts24_2015 = ofNullable(builder.getEsma_mifirRts24_2015()).map(f->f.build()).orElse(null);
			this.csa_derivativesReporting_2016 = ofNullable(builder.getCsa_derivativesReporting_2016()).map(f->f.build()).orElse(null);
			this.mas_sfa_2013 = ofNullable(builder.getMas_sfa_2013()).map(f->f.build()).orElse(null);
			this.asic_derivativesTransactionRules_2013 = ofNullable(builder.getAsic_derivativesTransactionRules_2013()).map(f->f.build()).orElse(null);
			this.esma_sftrRts_2019 = ofNullable(builder.getEsma_sftrRts_2019()).map(f->f.build()).orElse(null);
			this.other = ofNullable(builder.getOther()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("cftc_part43_2012")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part43_2012")
		public RegulatoryClassificationPart43_2012 getCftc_part43_2012() {
			return cftc_part43_2012;
		}
		
		@Override
		@RosettaAttribute("cftc_part43_2019")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part43_2019")
		public RegulatoryClassificationPart43_2019 getCftc_part43_2019() {
			return cftc_part43_2019;
		}
		
		@Override
		@RosettaAttribute("cftc_part45_2012")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part45_2012")
		public RegulatoryClassificationPart45_2012 getCftc_part45_2012() {
			return cftc_part45_2012;
		}
		
		@Override
		@RosettaAttribute("cftc_part45_2019")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part45_2019")
		public RegulatoryClassificationPart45_2019 getCftc_part45_2019() {
			return cftc_part45_2019;
		}
		
		@Override
		@RosettaAttribute("esma_emirRts_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_emirRts_2015")
		public RegulatoryClassificationEMIR_2015 getEsma_emirRts_2015() {
			return esma_emirRts_2015;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts6a_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts6a_2015")
		public RegulatoryClassificationMifirRTS6a_2015 getEsma_mifirRts6a_2015() {
			return esma_mifirRts6a_2015;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts6b_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts6b_2015")
		public RegulatoryClassificationMifirRTS6b_2015 getEsma_mifirRts6b_2015() {
			return esma_mifirRts6b_2015;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts22_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts22_2015")
		public RegulatoryClassificationMifirRTS22_2015 getEsma_mifirRts22_2015() {
			return esma_mifirRts22_2015;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts23_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts23_2015")
		public RegulatoryClassificationMifirRTS23_2015 getEsma_mifirRts23_2015() {
			return esma_mifirRts23_2015;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts24_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts24_2015")
		public RegulatoryClassificationMifirRTS24_2015 getEsma_mifirRts24_2015() {
			return esma_mifirRts24_2015;
		}
		
		@Override
		@RosettaAttribute("csa_derivativesReporting_2016")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csa_derivativesReporting_2016")
		public RegulatoryClassificationCSA_2016 getCsa_derivativesReporting_2016() {
			return csa_derivativesReporting_2016;
		}
		
		@Override
		@RosettaAttribute("mas_sfa_2013")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mas_sfa_2013")
		public RegulatoryClassificationMAS_2013 getMas_sfa_2013() {
			return mas_sfa_2013;
		}
		
		@Override
		@RosettaAttribute("asic_derivativesTransactionRules_2013")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asic_derivativesTransactionRules_2013")
		public RegulatoryClassificationASIC_2013 getAsic_derivativesTransactionRules_2013() {
			return asic_derivativesTransactionRules_2013;
		}
		
		@Override
		@RosettaAttribute("esma_sftrRts_2019")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_sftrRts_2019")
		public RegulatoryClassificationSFTR_2019 getEsma_sftrRts_2019() {
			return esma_sftrRts_2019;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("other")
		public List<? extends RegulatoryClassificationOther> getOther() {
			return other;
		}
		
		@Override
		public RegulationDetails build() {
			return this;
		}
		
		@Override
		public RegulationDetails.RegulationDetailsBuilder toBuilder() {
			RegulationDetails.RegulationDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulationDetails.RegulationDetailsBuilder builder) {
			ofNullable(getCftc_part43_2012()).ifPresent(builder::setCftc_part43_2012);
			ofNullable(getCftc_part43_2019()).ifPresent(builder::setCftc_part43_2019);
			ofNullable(getCftc_part45_2012()).ifPresent(builder::setCftc_part45_2012);
			ofNullable(getCftc_part45_2019()).ifPresent(builder::setCftc_part45_2019);
			ofNullable(getEsma_emirRts_2015()).ifPresent(builder::setEsma_emirRts_2015);
			ofNullable(getEsma_mifirRts6a_2015()).ifPresent(builder::setEsma_mifirRts6a_2015);
			ofNullable(getEsma_mifirRts6b_2015()).ifPresent(builder::setEsma_mifirRts6b_2015);
			ofNullable(getEsma_mifirRts22_2015()).ifPresent(builder::setEsma_mifirRts22_2015);
			ofNullable(getEsma_mifirRts23_2015()).ifPresent(builder::setEsma_mifirRts23_2015);
			ofNullable(getEsma_mifirRts24_2015()).ifPresent(builder::setEsma_mifirRts24_2015);
			ofNullable(getCsa_derivativesReporting_2016()).ifPresent(builder::setCsa_derivativesReporting_2016);
			ofNullable(getMas_sfa_2013()).ifPresent(builder::setMas_sfa_2013);
			ofNullable(getAsic_derivativesTransactionRules_2013()).ifPresent(builder::setAsic_derivativesTransactionRules_2013);
			ofNullable(getEsma_sftrRts_2019()).ifPresent(builder::setEsma_sftrRts_2019);
			ofNullable(getOther()).ifPresent(builder::setOther);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulationDetails _that = getType().cast(o);
		
			if (!Objects.equals(cftc_part43_2012, _that.getCftc_part43_2012())) return false;
			if (!Objects.equals(cftc_part43_2019, _that.getCftc_part43_2019())) return false;
			if (!Objects.equals(cftc_part45_2012, _that.getCftc_part45_2012())) return false;
			if (!Objects.equals(cftc_part45_2019, _that.getCftc_part45_2019())) return false;
			if (!Objects.equals(esma_emirRts_2015, _that.getEsma_emirRts_2015())) return false;
			if (!Objects.equals(esma_mifirRts6a_2015, _that.getEsma_mifirRts6a_2015())) return false;
			if (!Objects.equals(esma_mifirRts6b_2015, _that.getEsma_mifirRts6b_2015())) return false;
			if (!Objects.equals(esma_mifirRts22_2015, _that.getEsma_mifirRts22_2015())) return false;
			if (!Objects.equals(esma_mifirRts23_2015, _that.getEsma_mifirRts23_2015())) return false;
			if (!Objects.equals(esma_mifirRts24_2015, _that.getEsma_mifirRts24_2015())) return false;
			if (!Objects.equals(csa_derivativesReporting_2016, _that.getCsa_derivativesReporting_2016())) return false;
			if (!Objects.equals(mas_sfa_2013, _that.getMas_sfa_2013())) return false;
			if (!Objects.equals(asic_derivativesTransactionRules_2013, _that.getAsic_derivativesTransactionRules_2013())) return false;
			if (!Objects.equals(esma_sftrRts_2019, _that.getEsma_sftrRts_2019())) return false;
			if (!ListEquals.listEquals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cftc_part43_2012 != null ? cftc_part43_2012.hashCode() : 0);
			_result = 31 * _result + (cftc_part43_2019 != null ? cftc_part43_2019.hashCode() : 0);
			_result = 31 * _result + (cftc_part45_2012 != null ? cftc_part45_2012.hashCode() : 0);
			_result = 31 * _result + (cftc_part45_2019 != null ? cftc_part45_2019.hashCode() : 0);
			_result = 31 * _result + (esma_emirRts_2015 != null ? esma_emirRts_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts6a_2015 != null ? esma_mifirRts6a_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts6b_2015 != null ? esma_mifirRts6b_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts22_2015 != null ? esma_mifirRts22_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts23_2015 != null ? esma_mifirRts23_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts24_2015 != null ? esma_mifirRts24_2015.hashCode() : 0);
			_result = 31 * _result + (csa_derivativesReporting_2016 != null ? csa_derivativesReporting_2016.hashCode() : 0);
			_result = 31 * _result + (mas_sfa_2013 != null ? mas_sfa_2013.hashCode() : 0);
			_result = 31 * _result + (asic_derivativesTransactionRules_2013 != null ? asic_derivativesTransactionRules_2013.hashCode() : 0);
			_result = 31 * _result + (esma_sftrRts_2019 != null ? esma_sftrRts_2019.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulationDetails {" +
				"cftc_part43_2012=" + this.cftc_part43_2012 + ", " +
				"cftc_part43_2019=" + this.cftc_part43_2019 + ", " +
				"cftc_part45_2012=" + this.cftc_part45_2012 + ", " +
				"cftc_part45_2019=" + this.cftc_part45_2019 + ", " +
				"esma_emirRts_2015=" + this.esma_emirRts_2015 + ", " +
				"esma_mifirRts6a_2015=" + this.esma_mifirRts6a_2015 + ", " +
				"esma_mifirRts6b_2015=" + this.esma_mifirRts6b_2015 + ", " +
				"esma_mifirRts22_2015=" + this.esma_mifirRts22_2015 + ", " +
				"esma_mifirRts23_2015=" + this.esma_mifirRts23_2015 + ", " +
				"esma_mifirRts24_2015=" + this.esma_mifirRts24_2015 + ", " +
				"csa_derivativesReporting_2016=" + this.csa_derivativesReporting_2016 + ", " +
				"mas_sfa_2013=" + this.mas_sfa_2013 + ", " +
				"asic_derivativesTransactionRules_2013=" + this.asic_derivativesTransactionRules_2013 + ", " +
				"esma_sftrRts_2019=" + this.esma_sftrRts_2019 + ", " +
				"other=" + this.other +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulationDetails  ***********************/
	class RegulationDetailsBuilderImpl implements RegulationDetails.RegulationDetailsBuilder {
	
		protected RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder cftc_part43_2012;
		protected RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder cftc_part43_2019;
		protected RegulatoryClassificationPart45_2012.RegulatoryClassificationPart45_2012Builder cftc_part45_2012;
		protected RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder cftc_part45_2019;
		protected RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder esma_emirRts_2015;
		protected RegulatoryClassificationMifirRTS6a_2015.RegulatoryClassificationMifirRTS6a_2015Builder esma_mifirRts6a_2015;
		protected RegulatoryClassificationMifirRTS6b_2015.RegulatoryClassificationMifirRTS6b_2015Builder esma_mifirRts6b_2015;
		protected RegulatoryClassificationMifirRTS22_2015.RegulatoryClassificationMifirRTS22_2015Builder esma_mifirRts22_2015;
		protected RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder esma_mifirRts23_2015;
		protected RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder esma_mifirRts24_2015;
		protected RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder csa_derivativesReporting_2016;
		protected RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder mas_sfa_2013;
		protected RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder asic_derivativesTransactionRules_2013;
		protected RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder esma_sftrRts_2019;
		protected List<RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder> other = new ArrayList<>();
		
		@Override
		@RosettaAttribute("cftc_part43_2012")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part43_2012")
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder getCftc_part43_2012() {
			return cftc_part43_2012;
		}
		
		@Override
		public RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder getOrCreateCftc_part43_2012() {
			RegulatoryClassificationPart43_2012.RegulatoryClassificationPart43_2012Builder result;
			if (cftc_part43_2012!=null) {
				result = cftc_part43_2012;
			}
			else {
				result = cftc_part43_2012 = RegulatoryClassificationPart43_2012.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cftc_part43_2019")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part43_2019")
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder getCftc_part43_2019() {
			return cftc_part43_2019;
		}
		
		@Override
		public RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder getOrCreateCftc_part43_2019() {
			RegulatoryClassificationPart43_2019.RegulatoryClassificationPart43_2019Builder result;
			if (cftc_part43_2019!=null) {
				result = cftc_part43_2019;
			}
			else {
				result = cftc_part43_2019 = RegulatoryClassificationPart43_2019.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cftc_part45_2012")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part45_2012")
		public RegulatoryClassificationPart45_2012.RegulatoryClassificationPart45_2012Builder getCftc_part45_2012() {
			return cftc_part45_2012;
		}
		
		@Override
		public RegulatoryClassificationPart45_2012.RegulatoryClassificationPart45_2012Builder getOrCreateCftc_part45_2012() {
			RegulatoryClassificationPart45_2012.RegulatoryClassificationPart45_2012Builder result;
			if (cftc_part45_2012!=null) {
				result = cftc_part45_2012;
			}
			else {
				result = cftc_part45_2012 = RegulatoryClassificationPart45_2012.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cftc_part45_2019")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cftc_part45_2019")
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder getCftc_part45_2019() {
			return cftc_part45_2019;
		}
		
		@Override
		public RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder getOrCreateCftc_part45_2019() {
			RegulatoryClassificationPart45_2019.RegulatoryClassificationPart45_2019Builder result;
			if (cftc_part45_2019!=null) {
				result = cftc_part45_2019;
			}
			else {
				result = cftc_part45_2019 = RegulatoryClassificationPart45_2019.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esma_emirRts_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_emirRts_2015")
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder getEsma_emirRts_2015() {
			return esma_emirRts_2015;
		}
		
		@Override
		public RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder getOrCreateEsma_emirRts_2015() {
			RegulatoryClassificationEMIR_2015.RegulatoryClassificationEMIR_2015Builder result;
			if (esma_emirRts_2015!=null) {
				result = esma_emirRts_2015;
			}
			else {
				result = esma_emirRts_2015 = RegulatoryClassificationEMIR_2015.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts6a_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts6a_2015")
		public RegulatoryClassificationMifirRTS6a_2015.RegulatoryClassificationMifirRTS6a_2015Builder getEsma_mifirRts6a_2015() {
			return esma_mifirRts6a_2015;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS6a_2015.RegulatoryClassificationMifirRTS6a_2015Builder getOrCreateEsma_mifirRts6a_2015() {
			RegulatoryClassificationMifirRTS6a_2015.RegulatoryClassificationMifirRTS6a_2015Builder result;
			if (esma_mifirRts6a_2015!=null) {
				result = esma_mifirRts6a_2015;
			}
			else {
				result = esma_mifirRts6a_2015 = RegulatoryClassificationMifirRTS6a_2015.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts6b_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts6b_2015")
		public RegulatoryClassificationMifirRTS6b_2015.RegulatoryClassificationMifirRTS6b_2015Builder getEsma_mifirRts6b_2015() {
			return esma_mifirRts6b_2015;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS6b_2015.RegulatoryClassificationMifirRTS6b_2015Builder getOrCreateEsma_mifirRts6b_2015() {
			RegulatoryClassificationMifirRTS6b_2015.RegulatoryClassificationMifirRTS6b_2015Builder result;
			if (esma_mifirRts6b_2015!=null) {
				result = esma_mifirRts6b_2015;
			}
			else {
				result = esma_mifirRts6b_2015 = RegulatoryClassificationMifirRTS6b_2015.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts22_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts22_2015")
		public RegulatoryClassificationMifirRTS22_2015.RegulatoryClassificationMifirRTS22_2015Builder getEsma_mifirRts22_2015() {
			return esma_mifirRts22_2015;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS22_2015.RegulatoryClassificationMifirRTS22_2015Builder getOrCreateEsma_mifirRts22_2015() {
			RegulatoryClassificationMifirRTS22_2015.RegulatoryClassificationMifirRTS22_2015Builder result;
			if (esma_mifirRts22_2015!=null) {
				result = esma_mifirRts22_2015;
			}
			else {
				result = esma_mifirRts22_2015 = RegulatoryClassificationMifirRTS22_2015.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts23_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts23_2015")
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder getEsma_mifirRts23_2015() {
			return esma_mifirRts23_2015;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder getOrCreateEsma_mifirRts23_2015() {
			RegulatoryClassificationMifirRTS23_2015.RegulatoryClassificationMifirRTS23_2015Builder result;
			if (esma_mifirRts23_2015!=null) {
				result = esma_mifirRts23_2015;
			}
			else {
				result = esma_mifirRts23_2015 = RegulatoryClassificationMifirRTS23_2015.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esma_mifirRts24_2015")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_mifirRts24_2015")
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder getEsma_mifirRts24_2015() {
			return esma_mifirRts24_2015;
		}
		
		@Override
		public RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder getOrCreateEsma_mifirRts24_2015() {
			RegulatoryClassificationMifirRTS24_2015.RegulatoryClassificationMifirRTS24_2015Builder result;
			if (esma_mifirRts24_2015!=null) {
				result = esma_mifirRts24_2015;
			}
			else {
				result = esma_mifirRts24_2015 = RegulatoryClassificationMifirRTS24_2015.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("csa_derivativesReporting_2016")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("csa_derivativesReporting_2016")
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder getCsa_derivativesReporting_2016() {
			return csa_derivativesReporting_2016;
		}
		
		@Override
		public RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder getOrCreateCsa_derivativesReporting_2016() {
			RegulatoryClassificationCSA_2016.RegulatoryClassificationCSA_2016Builder result;
			if (csa_derivativesReporting_2016!=null) {
				result = csa_derivativesReporting_2016;
			}
			else {
				result = csa_derivativesReporting_2016 = RegulatoryClassificationCSA_2016.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mas_sfa_2013")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mas_sfa_2013")
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder getMas_sfa_2013() {
			return mas_sfa_2013;
		}
		
		@Override
		public RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder getOrCreateMas_sfa_2013() {
			RegulatoryClassificationMAS_2013.RegulatoryClassificationMAS_2013Builder result;
			if (mas_sfa_2013!=null) {
				result = mas_sfa_2013;
			}
			else {
				result = mas_sfa_2013 = RegulatoryClassificationMAS_2013.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("asic_derivativesTransactionRules_2013")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asic_derivativesTransactionRules_2013")
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder getAsic_derivativesTransactionRules_2013() {
			return asic_derivativesTransactionRules_2013;
		}
		
		@Override
		public RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder getOrCreateAsic_derivativesTransactionRules_2013() {
			RegulatoryClassificationASIC_2013.RegulatoryClassificationASIC_2013Builder result;
			if (asic_derivativesTransactionRules_2013!=null) {
				result = asic_derivativesTransactionRules_2013;
			}
			else {
				result = asic_derivativesTransactionRules_2013 = RegulatoryClassificationASIC_2013.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("esma_sftrRts_2019")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("esma_sftrRts_2019")
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder getEsma_sftrRts_2019() {
			return esma_sftrRts_2019;
		}
		
		@Override
		public RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder getOrCreateEsma_sftrRts_2019() {
			RegulatoryClassificationSFTR_2019.RegulatoryClassificationSFTR_2019Builder result;
			if (esma_sftrRts_2019!=null) {
				result = esma_sftrRts_2019;
			}
			else {
				result = esma_sftrRts_2019 = RegulatoryClassificationSFTR_2019.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("other")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("other")
		public List<? extends RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder> getOther() {
			return other;
		}
		
		@Override
		public RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder getOrCreateOther(int index) {
			if (other==null) {
				this.other = new ArrayList<>();
			}
			return getIndex(other, index, () -> {
						RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder newOther = RegulatoryClassificationOther.builder();
						return newOther;
					});
		}
		
		@RosettaAttribute("cftc_part43_2012")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cftc_part43_2012")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setCftc_part43_2012(RegulatoryClassificationPart43_2012 _cftc_part43_2012) {
			this.cftc_part43_2012 = _cftc_part43_2012 == null ? null : _cftc_part43_2012.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cftc_part43_2019")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cftc_part43_2019")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setCftc_part43_2019(RegulatoryClassificationPart43_2019 _cftc_part43_2019) {
			this.cftc_part43_2019 = _cftc_part43_2019 == null ? null : _cftc_part43_2019.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cftc_part45_2012")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cftc_part45_2012")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setCftc_part45_2012(RegulatoryClassificationPart45_2012 _cftc_part45_2012) {
			this.cftc_part45_2012 = _cftc_part45_2012 == null ? null : _cftc_part45_2012.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cftc_part45_2019")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cftc_part45_2019")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setCftc_part45_2019(RegulatoryClassificationPart45_2019 _cftc_part45_2019) {
			this.cftc_part45_2019 = _cftc_part45_2019 == null ? null : _cftc_part45_2019.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esma_emirRts_2015")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esma_emirRts_2015")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setEsma_emirRts_2015(RegulatoryClassificationEMIR_2015 _esma_emirRts_2015) {
			this.esma_emirRts_2015 = _esma_emirRts_2015 == null ? null : _esma_emirRts_2015.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esma_mifirRts6a_2015")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esma_mifirRts6a_2015")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts6a_2015(RegulatoryClassificationMifirRTS6a_2015 _esma_mifirRts6a_2015) {
			this.esma_mifirRts6a_2015 = _esma_mifirRts6a_2015 == null ? null : _esma_mifirRts6a_2015.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esma_mifirRts6b_2015")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esma_mifirRts6b_2015")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts6b_2015(RegulatoryClassificationMifirRTS6b_2015 _esma_mifirRts6b_2015) {
			this.esma_mifirRts6b_2015 = _esma_mifirRts6b_2015 == null ? null : _esma_mifirRts6b_2015.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esma_mifirRts22_2015")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esma_mifirRts22_2015")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts22_2015(RegulatoryClassificationMifirRTS22_2015 _esma_mifirRts22_2015) {
			this.esma_mifirRts22_2015 = _esma_mifirRts22_2015 == null ? null : _esma_mifirRts22_2015.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esma_mifirRts23_2015")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esma_mifirRts23_2015")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts23_2015(RegulatoryClassificationMifirRTS23_2015 _esma_mifirRts23_2015) {
			this.esma_mifirRts23_2015 = _esma_mifirRts23_2015 == null ? null : _esma_mifirRts23_2015.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esma_mifirRts24_2015")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esma_mifirRts24_2015")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setEsma_mifirRts24_2015(RegulatoryClassificationMifirRTS24_2015 _esma_mifirRts24_2015) {
			this.esma_mifirRts24_2015 = _esma_mifirRts24_2015 == null ? null : _esma_mifirRts24_2015.toBuilder();
			return this;
		}
		
		@RosettaAttribute("csa_derivativesReporting_2016")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("csa_derivativesReporting_2016")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setCsa_derivativesReporting_2016(RegulatoryClassificationCSA_2016 _csa_derivativesReporting_2016) {
			this.csa_derivativesReporting_2016 = _csa_derivativesReporting_2016 == null ? null : _csa_derivativesReporting_2016.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mas_sfa_2013")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mas_sfa_2013")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setMas_sfa_2013(RegulatoryClassificationMAS_2013 _mas_sfa_2013) {
			this.mas_sfa_2013 = _mas_sfa_2013 == null ? null : _mas_sfa_2013.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asic_derivativesTransactionRules_2013")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asic_derivativesTransactionRules_2013")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setAsic_derivativesTransactionRules_2013(RegulatoryClassificationASIC_2013 _asic_derivativesTransactionRules_2013) {
			this.asic_derivativesTransactionRules_2013 = _asic_derivativesTransactionRules_2013 == null ? null : _asic_derivativesTransactionRules_2013.toBuilder();
			return this;
		}
		
		@RosettaAttribute("esma_sftrRts_2019")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("esma_sftrRts_2019")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setEsma_sftrRts_2019(RegulatoryClassificationSFTR_2019 _esma_sftrRts_2019) {
			this.esma_sftrRts_2019 = _esma_sftrRts_2019 == null ? null : _esma_sftrRts_2019.toBuilder();
			return this;
		}
		
		@RosettaAttribute("other")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("other")
		@Override
		public RegulationDetails.RegulationDetailsBuilder addOther(RegulatoryClassificationOther _other) {
			if (_other != null) {
				this.other.add(_other.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulationDetails.RegulationDetailsBuilder addOther(RegulatoryClassificationOther _other, int idx) {
			getIndex(this.other, idx, () -> _other.toBuilder());
			return this;
		}
		
		@Override
		public RegulationDetails.RegulationDetailsBuilder addOther(List<? extends RegulatoryClassificationOther> others) {
			if (others != null) {
				for (final RegulatoryClassificationOther toAdd : others) {
					this.other.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("other")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("other")
		@Override
		public RegulationDetails.RegulationDetailsBuilder setOther(List<? extends RegulatoryClassificationOther> others) {
			if (others == null) {
				this.other = new ArrayList<>();
			} else {
				this.other = others.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulationDetails build() {
			return new RegulationDetails.RegulationDetailsImpl(this);
		}
		
		@Override
		public RegulationDetails.RegulationDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulationDetails.RegulationDetailsBuilder prune() {
			if (cftc_part43_2012!=null && !cftc_part43_2012.prune().hasData()) cftc_part43_2012 = null;
			if (cftc_part43_2019!=null && !cftc_part43_2019.prune().hasData()) cftc_part43_2019 = null;
			if (cftc_part45_2012!=null && !cftc_part45_2012.prune().hasData()) cftc_part45_2012 = null;
			if (cftc_part45_2019!=null && !cftc_part45_2019.prune().hasData()) cftc_part45_2019 = null;
			if (esma_emirRts_2015!=null && !esma_emirRts_2015.prune().hasData()) esma_emirRts_2015 = null;
			if (esma_mifirRts6a_2015!=null && !esma_mifirRts6a_2015.prune().hasData()) esma_mifirRts6a_2015 = null;
			if (esma_mifirRts6b_2015!=null && !esma_mifirRts6b_2015.prune().hasData()) esma_mifirRts6b_2015 = null;
			if (esma_mifirRts22_2015!=null && !esma_mifirRts22_2015.prune().hasData()) esma_mifirRts22_2015 = null;
			if (esma_mifirRts23_2015!=null && !esma_mifirRts23_2015.prune().hasData()) esma_mifirRts23_2015 = null;
			if (esma_mifirRts24_2015!=null && !esma_mifirRts24_2015.prune().hasData()) esma_mifirRts24_2015 = null;
			if (csa_derivativesReporting_2016!=null && !csa_derivativesReporting_2016.prune().hasData()) csa_derivativesReporting_2016 = null;
			if (mas_sfa_2013!=null && !mas_sfa_2013.prune().hasData()) mas_sfa_2013 = null;
			if (asic_derivativesTransactionRules_2013!=null && !asic_derivativesTransactionRules_2013.prune().hasData()) asic_derivativesTransactionRules_2013 = null;
			if (esma_sftrRts_2019!=null && !esma_sftrRts_2019.prune().hasData()) esma_sftrRts_2019 = null;
			other = other.stream().filter(b->b!=null).<RegulatoryClassificationOther.RegulatoryClassificationOtherBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCftc_part43_2012()!=null && getCftc_part43_2012().hasData()) return true;
			if (getCftc_part43_2019()!=null && getCftc_part43_2019().hasData()) return true;
			if (getCftc_part45_2012()!=null && getCftc_part45_2012().hasData()) return true;
			if (getCftc_part45_2019()!=null && getCftc_part45_2019().hasData()) return true;
			if (getEsma_emirRts_2015()!=null && getEsma_emirRts_2015().hasData()) return true;
			if (getEsma_mifirRts6a_2015()!=null && getEsma_mifirRts6a_2015().hasData()) return true;
			if (getEsma_mifirRts6b_2015()!=null && getEsma_mifirRts6b_2015().hasData()) return true;
			if (getEsma_mifirRts22_2015()!=null && getEsma_mifirRts22_2015().hasData()) return true;
			if (getEsma_mifirRts23_2015()!=null && getEsma_mifirRts23_2015().hasData()) return true;
			if (getEsma_mifirRts24_2015()!=null && getEsma_mifirRts24_2015().hasData()) return true;
			if (getCsa_derivativesReporting_2016()!=null && getCsa_derivativesReporting_2016().hasData()) return true;
			if (getMas_sfa_2013()!=null && getMas_sfa_2013().hasData()) return true;
			if (getAsic_derivativesTransactionRules_2013()!=null && getAsic_derivativesTransactionRules_2013().hasData()) return true;
			if (getEsma_sftrRts_2019()!=null && getEsma_sftrRts_2019().hasData()) return true;
			if (getOther()!=null && getOther().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulationDetails.RegulationDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulationDetails.RegulationDetailsBuilder o = (RegulationDetails.RegulationDetailsBuilder) other;
			
			merger.mergeRosetta(getCftc_part43_2012(), o.getCftc_part43_2012(), this::setCftc_part43_2012);
			merger.mergeRosetta(getCftc_part43_2019(), o.getCftc_part43_2019(), this::setCftc_part43_2019);
			merger.mergeRosetta(getCftc_part45_2012(), o.getCftc_part45_2012(), this::setCftc_part45_2012);
			merger.mergeRosetta(getCftc_part45_2019(), o.getCftc_part45_2019(), this::setCftc_part45_2019);
			merger.mergeRosetta(getEsma_emirRts_2015(), o.getEsma_emirRts_2015(), this::setEsma_emirRts_2015);
			merger.mergeRosetta(getEsma_mifirRts6a_2015(), o.getEsma_mifirRts6a_2015(), this::setEsma_mifirRts6a_2015);
			merger.mergeRosetta(getEsma_mifirRts6b_2015(), o.getEsma_mifirRts6b_2015(), this::setEsma_mifirRts6b_2015);
			merger.mergeRosetta(getEsma_mifirRts22_2015(), o.getEsma_mifirRts22_2015(), this::setEsma_mifirRts22_2015);
			merger.mergeRosetta(getEsma_mifirRts23_2015(), o.getEsma_mifirRts23_2015(), this::setEsma_mifirRts23_2015);
			merger.mergeRosetta(getEsma_mifirRts24_2015(), o.getEsma_mifirRts24_2015(), this::setEsma_mifirRts24_2015);
			merger.mergeRosetta(getCsa_derivativesReporting_2016(), o.getCsa_derivativesReporting_2016(), this::setCsa_derivativesReporting_2016);
			merger.mergeRosetta(getMas_sfa_2013(), o.getMas_sfa_2013(), this::setMas_sfa_2013);
			merger.mergeRosetta(getAsic_derivativesTransactionRules_2013(), o.getAsic_derivativesTransactionRules_2013(), this::setAsic_derivativesTransactionRules_2013);
			merger.mergeRosetta(getEsma_sftrRts_2019(), o.getEsma_sftrRts_2019(), this::setEsma_sftrRts_2019);
			merger.mergeRosetta(getOther(), o.getOther(), this::getOrCreateOther);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulationDetails _that = getType().cast(o);
		
			if (!Objects.equals(cftc_part43_2012, _that.getCftc_part43_2012())) return false;
			if (!Objects.equals(cftc_part43_2019, _that.getCftc_part43_2019())) return false;
			if (!Objects.equals(cftc_part45_2012, _that.getCftc_part45_2012())) return false;
			if (!Objects.equals(cftc_part45_2019, _that.getCftc_part45_2019())) return false;
			if (!Objects.equals(esma_emirRts_2015, _that.getEsma_emirRts_2015())) return false;
			if (!Objects.equals(esma_mifirRts6a_2015, _that.getEsma_mifirRts6a_2015())) return false;
			if (!Objects.equals(esma_mifirRts6b_2015, _that.getEsma_mifirRts6b_2015())) return false;
			if (!Objects.equals(esma_mifirRts22_2015, _that.getEsma_mifirRts22_2015())) return false;
			if (!Objects.equals(esma_mifirRts23_2015, _that.getEsma_mifirRts23_2015())) return false;
			if (!Objects.equals(esma_mifirRts24_2015, _that.getEsma_mifirRts24_2015())) return false;
			if (!Objects.equals(csa_derivativesReporting_2016, _that.getCsa_derivativesReporting_2016())) return false;
			if (!Objects.equals(mas_sfa_2013, _that.getMas_sfa_2013())) return false;
			if (!Objects.equals(asic_derivativesTransactionRules_2013, _that.getAsic_derivativesTransactionRules_2013())) return false;
			if (!Objects.equals(esma_sftrRts_2019, _that.getEsma_sftrRts_2019())) return false;
			if (!ListEquals.listEquals(other, _that.getOther())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cftc_part43_2012 != null ? cftc_part43_2012.hashCode() : 0);
			_result = 31 * _result + (cftc_part43_2019 != null ? cftc_part43_2019.hashCode() : 0);
			_result = 31 * _result + (cftc_part45_2012 != null ? cftc_part45_2012.hashCode() : 0);
			_result = 31 * _result + (cftc_part45_2019 != null ? cftc_part45_2019.hashCode() : 0);
			_result = 31 * _result + (esma_emirRts_2015 != null ? esma_emirRts_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts6a_2015 != null ? esma_mifirRts6a_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts6b_2015 != null ? esma_mifirRts6b_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts22_2015 != null ? esma_mifirRts22_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts23_2015 != null ? esma_mifirRts23_2015.hashCode() : 0);
			_result = 31 * _result + (esma_mifirRts24_2015 != null ? esma_mifirRts24_2015.hashCode() : 0);
			_result = 31 * _result + (csa_derivativesReporting_2016 != null ? csa_derivativesReporting_2016.hashCode() : 0);
			_result = 31 * _result + (mas_sfa_2013 != null ? mas_sfa_2013.hashCode() : 0);
			_result = 31 * _result + (asic_derivativesTransactionRules_2013 != null ? asic_derivativesTransactionRules_2013.hashCode() : 0);
			_result = 31 * _result + (esma_sftrRts_2019 != null ? esma_sftrRts_2019.hashCode() : 0);
			_result = 31 * _result + (other != null ? other.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulationDetailsBuilder {" +
				"cftc_part43_2012=" + this.cftc_part43_2012 + ", " +
				"cftc_part43_2019=" + this.cftc_part43_2019 + ", " +
				"cftc_part45_2012=" + this.cftc_part45_2012 + ", " +
				"cftc_part45_2019=" + this.cftc_part45_2019 + ", " +
				"esma_emirRts_2015=" + this.esma_emirRts_2015 + ", " +
				"esma_mifirRts6a_2015=" + this.esma_mifirRts6a_2015 + ", " +
				"esma_mifirRts6b_2015=" + this.esma_mifirRts6b_2015 + ", " +
				"esma_mifirRts22_2015=" + this.esma_mifirRts22_2015 + ", " +
				"esma_mifirRts23_2015=" + this.esma_mifirRts23_2015 + ", " +
				"esma_mifirRts24_2015=" + this.esma_mifirRts24_2015 + ", " +
				"csa_derivativesReporting_2016=" + this.csa_derivativesReporting_2016 + ", " +
				"mas_sfa_2013=" + this.mas_sfa_2013 + ", " +
				"asic_derivativesTransactionRules_2013=" + this.asic_derivativesTransactionRules_2013 + ", " +
				"esma_sftrRts_2019=" + this.esma_sftrRts_2019 + ", " +
				"other=" + this.other +
			'}';
		}
	}
}
