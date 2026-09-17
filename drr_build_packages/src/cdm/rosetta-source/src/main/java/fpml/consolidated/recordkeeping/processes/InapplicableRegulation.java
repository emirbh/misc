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
import fpml.consolidated.doc.ReasonCode;
import fpml.consolidated.recordkeeping.processes.meta.InapplicableRegulationMeta;
import fpml.consolidated.reg.fpmlreporting.shared.RegulationName;
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
 * Provision 
 *
 */
@RosettaDataType(value="InapplicableRegulation", builder=InapplicableRegulation.InapplicableRegulationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InapplicableRegulation", model="fpml", builder=InapplicableRegulation.InapplicableRegulationBuilderImpl.class, version="2.1.1")
public interface InapplicableRegulation extends RosettaModelObject {

	InapplicableRegulationMeta metaData = new InapplicableRegulationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getSupervisoryBody();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends RegulationName> getRegulation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	ReasonCode getWithdrawalReasonCode();

	/*********************** Build Methods  ***********************/
	InapplicableRegulation build();
	
	InapplicableRegulation.InapplicableRegulationBuilder toBuilder();
	
	static InapplicableRegulation.InapplicableRegulationBuilder builder() {
		return new InapplicableRegulation.InapplicableRegulationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InapplicableRegulation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InapplicableRegulation> getType() {
		return InapplicableRegulation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
		processRosetta(path.newSubPath("regulation"), processor, RegulationName.class, getRegulation());
		processRosetta(path.newSubPath("withdrawalReasonCode"), processor, ReasonCode.class, getWithdrawalReasonCode());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InapplicableRegulationBuilder extends InapplicableRegulation, RosettaModelObjectBuilder {
		RegulationName.RegulationNameBuilder getOrCreateRegulation(int index);
		@Override
		List<? extends RegulationName.RegulationNameBuilder> getRegulation();
		ReasonCode.ReasonCodeBuilder getOrCreateWithdrawalReasonCode();
		@Override
		ReasonCode.ReasonCodeBuilder getWithdrawalReasonCode();
		InapplicableRegulation.InapplicableRegulationBuilder setSupervisoryBody(String supervisoryBody);
		InapplicableRegulation.InapplicableRegulationBuilder addRegulation(RegulationName regulation);
		InapplicableRegulation.InapplicableRegulationBuilder addRegulation(RegulationName regulation, int idx);
		InapplicableRegulation.InapplicableRegulationBuilder addRegulation(List<? extends RegulationName> regulation);
		InapplicableRegulation.InapplicableRegulationBuilder setRegulation(List<? extends RegulationName> regulation);
		InapplicableRegulation.InapplicableRegulationBuilder setWithdrawalReasonCode(ReasonCode withdrawalReasonCode);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("supervisoryBody"), String.class, getSupervisoryBody(), this);
			processRosetta(path.newSubPath("regulation"), processor, RegulationName.RegulationNameBuilder.class, getRegulation());
			processRosetta(path.newSubPath("withdrawalReasonCode"), processor, ReasonCode.ReasonCodeBuilder.class, getWithdrawalReasonCode());
		}
		

		InapplicableRegulation.InapplicableRegulationBuilder prune();
	}

	/*********************** Immutable Implementation of InapplicableRegulation  ***********************/
	class InapplicableRegulationImpl implements InapplicableRegulation {
		private final String supervisoryBody;
		private final List<? extends RegulationName> regulation;
		private final ReasonCode withdrawalReasonCode;
		
		protected InapplicableRegulationImpl(InapplicableRegulation.InapplicableRegulationBuilder builder) {
			this.supervisoryBody = builder.getSupervisoryBody();
			this.regulation = ofNullable(builder.getRegulation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.withdrawalReasonCode = ofNullable(builder.getWithdrawalReasonCode()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public String getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regulation")
		public List<? extends RegulationName> getRegulation() {
			return regulation;
		}
		
		@Override
		@RosettaAttribute("withdrawalReasonCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalReasonCode")
		public ReasonCode getWithdrawalReasonCode() {
			return withdrawalReasonCode;
		}
		
		@Override
		public InapplicableRegulation build() {
			return this;
		}
		
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder toBuilder() {
			InapplicableRegulation.InapplicableRegulationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InapplicableRegulation.InapplicableRegulationBuilder builder) {
			ofNullable(getSupervisoryBody()).ifPresent(builder::setSupervisoryBody);
			ofNullable(getRegulation()).ifPresent(builder::setRegulation);
			ofNullable(getWithdrawalReasonCode()).ifPresent(builder::setWithdrawalReasonCode);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InapplicableRegulation _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!ListEquals.listEquals(regulation, _that.getRegulation())) return false;
			if (!Objects.equals(withdrawalReasonCode, _that.getWithdrawalReasonCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (regulation != null ? regulation.hashCode() : 0);
			_result = 31 * _result + (withdrawalReasonCode != null ? withdrawalReasonCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InapplicableRegulation {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"regulation=" + this.regulation + ", " +
				"withdrawalReasonCode=" + this.withdrawalReasonCode +
			'}';
		}
	}

	/*********************** Builder Implementation of InapplicableRegulation  ***********************/
	class InapplicableRegulationBuilderImpl implements InapplicableRegulation.InapplicableRegulationBuilder {
	
		protected String supervisoryBody;
		protected List<RegulationName.RegulationNameBuilder> regulation = new ArrayList<>();
		protected ReasonCode.ReasonCodeBuilder withdrawalReasonCode;
		
		@Override
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("supervisoryBody")
		public String getSupervisoryBody() {
			return supervisoryBody;
		}
		
		@Override
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regulation")
		public List<? extends RegulationName.RegulationNameBuilder> getRegulation() {
			return regulation;
		}
		
		@Override
		public RegulationName.RegulationNameBuilder getOrCreateRegulation(int index) {
			if (regulation==null) {
				this.regulation = new ArrayList<>();
			}
			return getIndex(regulation, index, () -> {
						RegulationName.RegulationNameBuilder newRegulation = RegulationName.builder();
						return newRegulation;
					});
		}
		
		@Override
		@RosettaAttribute("withdrawalReasonCode")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawalReasonCode")
		public ReasonCode.ReasonCodeBuilder getWithdrawalReasonCode() {
			return withdrawalReasonCode;
		}
		
		@Override
		public ReasonCode.ReasonCodeBuilder getOrCreateWithdrawalReasonCode() {
			ReasonCode.ReasonCodeBuilder result;
			if (withdrawalReasonCode!=null) {
				result = withdrawalReasonCode;
			}
			else {
				result = withdrawalReasonCode = ReasonCode.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("supervisoryBody")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("supervisoryBody")
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder setSupervisoryBody(String _supervisoryBody) {
			this.supervisoryBody = _supervisoryBody == null ? null : _supervisoryBody;
			return this;
		}
		
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("regulation")
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder addRegulation(RegulationName _regulation) {
			if (_regulation != null) {
				this.regulation.add(_regulation.toBuilder());
			}
			return this;
		}
		
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder addRegulation(RegulationName _regulation, int idx) {
			getIndex(this.regulation, idx, () -> _regulation.toBuilder());
			return this;
		}
		
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder addRegulation(List<? extends RegulationName> regulations) {
			if (regulations != null) {
				for (final RegulationName toAdd : regulations) {
					this.regulation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("regulation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("regulation")
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder setRegulation(List<? extends RegulationName> regulations) {
			if (regulations == null) {
				this.regulation = new ArrayList<>();
			} else {
				this.regulation = regulations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("withdrawalReasonCode")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawalReasonCode")
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder setWithdrawalReasonCode(ReasonCode _withdrawalReasonCode) {
			this.withdrawalReasonCode = _withdrawalReasonCode == null ? null : _withdrawalReasonCode.toBuilder();
			return this;
		}
		
		@Override
		public InapplicableRegulation build() {
			return new InapplicableRegulation.InapplicableRegulationImpl(this);
		}
		
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder prune() {
			regulation = regulation.stream().filter(b->b!=null).<RegulationName.RegulationNameBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (withdrawalReasonCode!=null && !withdrawalReasonCode.prune().hasData()) withdrawalReasonCode = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupervisoryBody()!=null) return true;
			if (getRegulation()!=null && getRegulation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getWithdrawalReasonCode()!=null && getWithdrawalReasonCode().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InapplicableRegulation.InapplicableRegulationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InapplicableRegulation.InapplicableRegulationBuilder o = (InapplicableRegulation.InapplicableRegulationBuilder) other;
			
			merger.mergeRosetta(getRegulation(), o.getRegulation(), this::getOrCreateRegulation);
			merger.mergeRosetta(getWithdrawalReasonCode(), o.getWithdrawalReasonCode(), this::setWithdrawalReasonCode);
			
			merger.mergeBasic(getSupervisoryBody(), o.getSupervisoryBody(), this::setSupervisoryBody);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InapplicableRegulation _that = getType().cast(o);
		
			if (!Objects.equals(supervisoryBody, _that.getSupervisoryBody())) return false;
			if (!ListEquals.listEquals(regulation, _that.getRegulation())) return false;
			if (!Objects.equals(withdrawalReasonCode, _that.getWithdrawalReasonCode())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supervisoryBody != null ? supervisoryBody.hashCode() : 0);
			_result = 31 * _result + (regulation != null ? regulation.hashCode() : 0);
			_result = 31 * _result + (withdrawalReasonCode != null ? withdrawalReasonCode.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InapplicableRegulationBuilder {" +
				"supervisoryBody=" + this.supervisoryBody + ", " +
				"regulation=" + this.regulation + ", " +
				"withdrawalReasonCode=" + this.withdrawalReasonCode +
			'}';
		}
	}
}
