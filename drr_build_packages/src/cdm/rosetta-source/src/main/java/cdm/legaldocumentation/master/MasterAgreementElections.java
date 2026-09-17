package cdm.legaldocumentation.master;

import cdm.legaldocumentation.master.icma.GlobalMasterRepoAgreement;
import cdm.legaldocumentation.master.isda.MasterAgreement;
import cdm.legaldocumentation.master.isla.GlobalMasterSecuritiesLendingAgreement;
import cdm.legaldocumentation.master.meta.MasterAgreementElectionsMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A representation of a master agreement extended from a base agreement of shared elections.
 * @version 6.23.0
 */
@RosettaDataType(value="MasterAgreementElections", builder=MasterAgreementElections.MasterAgreementElectionsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MasterAgreementElections", model="cdm", builder=MasterAgreementElections.MasterAgreementElectionsBuilderImpl.class, version="6.23.0")
public interface MasterAgreementElections extends RosettaModelObject {

	MasterAgreementElectionsMeta metaData = new MasterAgreementElectionsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The set of elections that define a GMSLA.
	 */
	GlobalMasterSecuritiesLendingAgreement getIslaGmsla();
	/**
	 * The set of elections that define a GMRA.
	 */
	GlobalMasterRepoAgreement getIcmaGmra();
	/**
	 * The set of elections that define an ISDA Master Agreement.
	 */
	MasterAgreement getIsdaMaster();

	/*********************** Build Methods  ***********************/
	MasterAgreementElections build();
	
	MasterAgreementElections.MasterAgreementElectionsBuilder toBuilder();
	
	static MasterAgreementElections.MasterAgreementElectionsBuilder builder() {
		return new MasterAgreementElections.MasterAgreementElectionsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MasterAgreementElections> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MasterAgreementElections> getType() {
		return MasterAgreementElections.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("islaGmsla"), processor, GlobalMasterSecuritiesLendingAgreement.class, getIslaGmsla());
		processRosetta(path.newSubPath("icmaGmra"), processor, GlobalMasterRepoAgreement.class, getIcmaGmra());
		processRosetta(path.newSubPath("isdaMaster"), processor, MasterAgreement.class, getIsdaMaster());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MasterAgreementElectionsBuilder extends MasterAgreementElections, RosettaModelObjectBuilder {
		GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder getOrCreateIslaGmsla();
		@Override
		GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder getIslaGmsla();
		GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder getOrCreateIcmaGmra();
		@Override
		GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder getIcmaGmra();
		MasterAgreement.MasterAgreementBuilder getOrCreateIsdaMaster();
		@Override
		MasterAgreement.MasterAgreementBuilder getIsdaMaster();
		MasterAgreementElections.MasterAgreementElectionsBuilder setIslaGmsla(GlobalMasterSecuritiesLendingAgreement islaGmsla);
		MasterAgreementElections.MasterAgreementElectionsBuilder setIcmaGmra(GlobalMasterRepoAgreement icmaGmra);
		MasterAgreementElections.MasterAgreementElectionsBuilder setIsdaMaster(MasterAgreement isdaMaster);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("islaGmsla"), processor, GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder.class, getIslaGmsla());
			processRosetta(path.newSubPath("icmaGmra"), processor, GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder.class, getIcmaGmra());
			processRosetta(path.newSubPath("isdaMaster"), processor, MasterAgreement.MasterAgreementBuilder.class, getIsdaMaster());
		}
		

		MasterAgreementElections.MasterAgreementElectionsBuilder prune();
	}

	/*********************** Immutable Implementation of MasterAgreementElections  ***********************/
	class MasterAgreementElectionsImpl implements MasterAgreementElections {
		private final GlobalMasterSecuritiesLendingAgreement islaGmsla;
		private final GlobalMasterRepoAgreement icmaGmra;
		private final MasterAgreement isdaMaster;
		
		protected MasterAgreementElectionsImpl(MasterAgreementElections.MasterAgreementElectionsBuilder builder) {
			this.islaGmsla = ofNullable(builder.getIslaGmsla()).map(f->f.build()).orElse(null);
			this.icmaGmra = ofNullable(builder.getIcmaGmra()).map(f->f.build()).orElse(null);
			this.isdaMaster = ofNullable(builder.getIsdaMaster()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("islaGmsla")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("islaGmsla")
		public GlobalMasterSecuritiesLendingAgreement getIslaGmsla() {
			return islaGmsla;
		}
		
		@Override
		@RosettaAttribute("icmaGmra")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("icmaGmra")
		public GlobalMasterRepoAgreement getIcmaGmra() {
			return icmaGmra;
		}
		
		@Override
		@RosettaAttribute("isdaMaster")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isdaMaster")
		public MasterAgreement getIsdaMaster() {
			return isdaMaster;
		}
		
		@Override
		public MasterAgreementElections build() {
			return this;
		}
		
		@Override
		public MasterAgreementElections.MasterAgreementElectionsBuilder toBuilder() {
			MasterAgreementElections.MasterAgreementElectionsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementElections.MasterAgreementElectionsBuilder builder) {
			ofNullable(getIslaGmsla()).ifPresent(builder::setIslaGmsla);
			ofNullable(getIcmaGmra()).ifPresent(builder::setIcmaGmra);
			ofNullable(getIsdaMaster()).ifPresent(builder::setIsdaMaster);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(islaGmsla, _that.getIslaGmsla())) return false;
			if (!Objects.equals(icmaGmra, _that.getIcmaGmra())) return false;
			if (!Objects.equals(isdaMaster, _that.getIsdaMaster())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (islaGmsla != null ? islaGmsla.hashCode() : 0);
			_result = 31 * _result + (icmaGmra != null ? icmaGmra.hashCode() : 0);
			_result = 31 * _result + (isdaMaster != null ? isdaMaster.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementElections {" +
				"islaGmsla=" + this.islaGmsla + ", " +
				"icmaGmra=" + this.icmaGmra + ", " +
				"isdaMaster=" + this.isdaMaster +
			'}';
		}
	}

	/*********************** Builder Implementation of MasterAgreementElections  ***********************/
	class MasterAgreementElectionsBuilderImpl implements MasterAgreementElections.MasterAgreementElectionsBuilder {
	
		protected GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder islaGmsla;
		protected GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder icmaGmra;
		protected MasterAgreement.MasterAgreementBuilder isdaMaster;
		
		@Override
		@RosettaAttribute("islaGmsla")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("islaGmsla")
		public GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder getIslaGmsla() {
			return islaGmsla;
		}
		
		@Override
		public GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder getOrCreateIslaGmsla() {
			GlobalMasterSecuritiesLendingAgreement.GlobalMasterSecuritiesLendingAgreementBuilder result;
			if (islaGmsla!=null) {
				result = islaGmsla;
			}
			else {
				result = islaGmsla = GlobalMasterSecuritiesLendingAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("icmaGmra")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("icmaGmra")
		public GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder getIcmaGmra() {
			return icmaGmra;
		}
		
		@Override
		public GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder getOrCreateIcmaGmra() {
			GlobalMasterRepoAgreement.GlobalMasterRepoAgreementBuilder result;
			if (icmaGmra!=null) {
				result = icmaGmra;
			}
			else {
				result = icmaGmra = GlobalMasterRepoAgreement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isdaMaster")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("isdaMaster")
		public MasterAgreement.MasterAgreementBuilder getIsdaMaster() {
			return isdaMaster;
		}
		
		@Override
		public MasterAgreement.MasterAgreementBuilder getOrCreateIsdaMaster() {
			MasterAgreement.MasterAgreementBuilder result;
			if (isdaMaster!=null) {
				result = isdaMaster;
			}
			else {
				result = isdaMaster = MasterAgreement.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("islaGmsla")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("islaGmsla")
		@Override
		public MasterAgreementElections.MasterAgreementElectionsBuilder setIslaGmsla(GlobalMasterSecuritiesLendingAgreement _islaGmsla) {
			this.islaGmsla = _islaGmsla == null ? null : _islaGmsla.toBuilder();
			return this;
		}
		
		@RosettaAttribute("icmaGmra")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("icmaGmra")
		@Override
		public MasterAgreementElections.MasterAgreementElectionsBuilder setIcmaGmra(GlobalMasterRepoAgreement _icmaGmra) {
			this.icmaGmra = _icmaGmra == null ? null : _icmaGmra.toBuilder();
			return this;
		}
		
		@RosettaAttribute("isdaMaster")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isdaMaster")
		@Override
		public MasterAgreementElections.MasterAgreementElectionsBuilder setIsdaMaster(MasterAgreement _isdaMaster) {
			this.isdaMaster = _isdaMaster == null ? null : _isdaMaster.toBuilder();
			return this;
		}
		
		@Override
		public MasterAgreementElections build() {
			return new MasterAgreementElections.MasterAgreementElectionsImpl(this);
		}
		
		@Override
		public MasterAgreementElections.MasterAgreementElectionsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementElections.MasterAgreementElectionsBuilder prune() {
			if (islaGmsla!=null && !islaGmsla.prune().hasData()) islaGmsla = null;
			if (icmaGmra!=null && !icmaGmra.prune().hasData()) icmaGmra = null;
			if (isdaMaster!=null && !isdaMaster.prune().hasData()) isdaMaster = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIslaGmsla()!=null && getIslaGmsla().hasData()) return true;
			if (getIcmaGmra()!=null && getIcmaGmra().hasData()) return true;
			if (getIsdaMaster()!=null && getIsdaMaster().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementElections.MasterAgreementElectionsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementElections.MasterAgreementElectionsBuilder o = (MasterAgreementElections.MasterAgreementElectionsBuilder) other;
			
			merger.mergeRosetta(getIslaGmsla(), o.getIslaGmsla(), this::setIslaGmsla);
			merger.mergeRosetta(getIcmaGmra(), o.getIcmaGmra(), this::setIcmaGmra);
			merger.mergeRosetta(getIsdaMaster(), o.getIsdaMaster(), this::setIsdaMaster);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementElections _that = getType().cast(o);
		
			if (!Objects.equals(islaGmsla, _that.getIslaGmsla())) return false;
			if (!Objects.equals(icmaGmra, _that.getIcmaGmra())) return false;
			if (!Objects.equals(isdaMaster, _that.getIsdaMaster())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (islaGmsla != null ? islaGmsla.hashCode() : 0);
			_result = 31 * _result + (icmaGmra != null ? icmaGmra.hashCode() : 0);
			_result = 31 * _result + (isdaMaster != null ? isdaMaster.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementElectionsBuilder {" +
				"islaGmsla=" + this.islaGmsla + ", " +
				"icmaGmra=" + this.icmaGmra + ", " +
				"isdaMaster=" + this.isdaMaster +
			'}';
		}
	}
}
