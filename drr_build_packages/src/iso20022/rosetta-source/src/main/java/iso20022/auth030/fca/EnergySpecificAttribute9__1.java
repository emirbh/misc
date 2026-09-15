package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.EnergySpecificAttribute9__1Meta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Attributes of energy related derivatives.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergySpecificAttribute9__1", builder=EnergySpecificAttribute9__1.EnergySpecificAttribute9__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergySpecificAttribute9__1", model="iso20022", builder=EnergySpecificAttribute9__1.EnergySpecificAttribute9__1BuilderImpl.class, version="${project.version}")
public interface EnergySpecificAttribute9__1 extends RosettaModelObject {

	EnergySpecificAttribute9__1Meta metaData = new EnergySpecificAttribute9__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the delivery point(s) of market area(s) for energy derivative contracts.
	 */
	DeliveryInterconnectionPoint1Choice__1 getDlvryPtOrZone();
	/**
	 * Identification of the border(s) or border point(s) of a transportation contract.
	 */
	DeliveryInterconnectionPoint1Choice__1 getIntrCnnctnPt();
	/**
	 * Identification of the delivery profile.
	 */
	EnergyLoadType1Code getLdTp();
	/**
	 * Attributes related to delivery of derivative contracts.
	 */
	List<? extends EnergyDeliveryAttribute10__1> getDlvryAttr();

	/*********************** Build Methods  ***********************/
	EnergySpecificAttribute9__1 build();
	
	EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder toBuilder();
	
	static EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder builder() {
		return new EnergySpecificAttribute9__1.EnergySpecificAttribute9__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergySpecificAttribute9__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergySpecificAttribute9__1> getType() {
		return EnergySpecificAttribute9__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dlvryPtOrZone"), processor, DeliveryInterconnectionPoint1Choice__1.class, getDlvryPtOrZone());
		processRosetta(path.newSubPath("intrCnnctnPt"), processor, DeliveryInterconnectionPoint1Choice__1.class, getIntrCnnctnPt());
		processor.processBasic(path.newSubPath("ldTp"), EnergyLoadType1Code.class, getLdTp(), this);
		processRosetta(path.newSubPath("dlvryAttr"), processor, EnergyDeliveryAttribute10__1.class, getDlvryAttr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergySpecificAttribute9__1Builder extends EnergySpecificAttribute9__1, RosettaModelObjectBuilder {
		DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getOrCreateDlvryPtOrZone();
		@Override
		DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getDlvryPtOrZone();
		DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getOrCreateIntrCnnctnPt();
		@Override
		DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getIntrCnnctnPt();
		EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder getOrCreateDlvryAttr(int index);
		@Override
		List<? extends EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder> getDlvryAttr();
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setDlvryPtOrZone(DeliveryInterconnectionPoint1Choice__1 dlvryPtOrZone);
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setIntrCnnctnPt(DeliveryInterconnectionPoint1Choice__1 intrCnnctnPt);
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setLdTp(EnergyLoadType1Code ldTp);
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder addDlvryAttr(EnergyDeliveryAttribute10__1 dlvryAttr);
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder addDlvryAttr(EnergyDeliveryAttribute10__1 dlvryAttr, int idx);
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder addDlvryAttr(List<? extends EnergyDeliveryAttribute10__1> dlvryAttr);
		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setDlvryAttr(List<? extends EnergyDeliveryAttribute10__1> dlvryAttr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dlvryPtOrZone"), processor, DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder.class, getDlvryPtOrZone());
			processRosetta(path.newSubPath("intrCnnctnPt"), processor, DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder.class, getIntrCnnctnPt());
			processor.processBasic(path.newSubPath("ldTp"), EnergyLoadType1Code.class, getLdTp(), this);
			processRosetta(path.newSubPath("dlvryAttr"), processor, EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder.class, getDlvryAttr());
		}
		

		EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder prune();
	}

	/*********************** Immutable Implementation of EnergySpecificAttribute9__1  ***********************/
	class EnergySpecificAttribute9__1Impl implements EnergySpecificAttribute9__1 {
		private final DeliveryInterconnectionPoint1Choice__1 dlvryPtOrZone;
		private final DeliveryInterconnectionPoint1Choice__1 intrCnnctnPt;
		private final EnergyLoadType1Code ldTp;
		private final List<? extends EnergyDeliveryAttribute10__1> dlvryAttr;
		
		protected EnergySpecificAttribute9__1Impl(EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder builder) {
			this.dlvryPtOrZone = ofNullable(builder.getDlvryPtOrZone()).map(f->f.build()).orElse(null);
			this.intrCnnctnPt = ofNullable(builder.getIntrCnnctnPt()).map(f->f.build()).orElse(null);
			this.ldTp = builder.getLdTp();
			this.dlvryAttr = ofNullable(builder.getDlvryAttr()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dlvryPtOrZone")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlvryPtOrZone")
		public DeliveryInterconnectionPoint1Choice__1 getDlvryPtOrZone() {
			return dlvryPtOrZone;
		}
		
		@Override
		@RosettaAttribute("intrCnnctnPt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrCnnctnPt")
		public DeliveryInterconnectionPoint1Choice__1 getIntrCnnctnPt() {
			return intrCnnctnPt;
		}
		
		@Override
		@RosettaAttribute("ldTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ldTp")
		public EnergyLoadType1Code getLdTp() {
			return ldTp;
		}
		
		@Override
		@RosettaAttribute("dlvryAttr")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dlvryAttr")
		public List<? extends EnergyDeliveryAttribute10__1> getDlvryAttr() {
			return dlvryAttr;
		}
		
		@Override
		public EnergySpecificAttribute9__1 build() {
			return this;
		}
		
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder toBuilder() {
			EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder builder) {
			ofNullable(getDlvryPtOrZone()).ifPresent(builder::setDlvryPtOrZone);
			ofNullable(getIntrCnnctnPt()).ifPresent(builder::setIntrCnnctnPt);
			ofNullable(getLdTp()).ifPresent(builder::setLdTp);
			ofNullable(getDlvryAttr()).ifPresent(builder::setDlvryAttr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergySpecificAttribute9__1 _that = getType().cast(o);
		
			if (!Objects.equals(dlvryPtOrZone, _that.getDlvryPtOrZone())) return false;
			if (!Objects.equals(intrCnnctnPt, _that.getIntrCnnctnPt())) return false;
			if (!Objects.equals(ldTp, _that.getLdTp())) return false;
			if (!ListEquals.listEquals(dlvryAttr, _that.getDlvryAttr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dlvryPtOrZone != null ? dlvryPtOrZone.hashCode() : 0);
			_result = 31 * _result + (intrCnnctnPt != null ? intrCnnctnPt.hashCode() : 0);
			_result = 31 * _result + (ldTp != null ? ldTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dlvryAttr != null ? dlvryAttr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnergySpecificAttribute9__1 {" +
				"dlvryPtOrZone=" + this.dlvryPtOrZone + ", " +
				"intrCnnctnPt=" + this.intrCnnctnPt + ", " +
				"ldTp=" + this.ldTp + ", " +
				"dlvryAttr=" + this.dlvryAttr +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergySpecificAttribute9__1  ***********************/
	class EnergySpecificAttribute9__1BuilderImpl implements EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder {
	
		protected DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder dlvryPtOrZone;
		protected DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder intrCnnctnPt;
		protected EnergyLoadType1Code ldTp;
		protected List<EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder> dlvryAttr = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dlvryPtOrZone")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dlvryPtOrZone")
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getDlvryPtOrZone() {
			return dlvryPtOrZone;
		}
		
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getOrCreateDlvryPtOrZone() {
			DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder result;
			if (dlvryPtOrZone!=null) {
				result = dlvryPtOrZone;
			}
			else {
				result = dlvryPtOrZone = DeliveryInterconnectionPoint1Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("intrCnnctnPt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("intrCnnctnPt")
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getIntrCnnctnPt() {
			return intrCnnctnPt;
		}
		
		@Override
		public DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder getOrCreateIntrCnnctnPt() {
			DeliveryInterconnectionPoint1Choice__1.DeliveryInterconnectionPoint1Choice__1Builder result;
			if (intrCnnctnPt!=null) {
				result = intrCnnctnPt;
			}
			else {
				result = intrCnnctnPt = DeliveryInterconnectionPoint1Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ldTp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ldTp")
		public EnergyLoadType1Code getLdTp() {
			return ldTp;
		}
		
		@Override
		@RosettaAttribute("dlvryAttr")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dlvryAttr")
		public List<? extends EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder> getDlvryAttr() {
			return dlvryAttr;
		}
		
		@Override
		public EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder getOrCreateDlvryAttr(int index) {
			if (dlvryAttr==null) {
				this.dlvryAttr = new ArrayList<>();
			}
			return getIndex(dlvryAttr, index, () -> {
						EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder newDlvryAttr = EnergyDeliveryAttribute10__1.builder();
						return newDlvryAttr;
					});
		}
		
		@RosettaAttribute("dlvryPtOrZone")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dlvryPtOrZone")
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setDlvryPtOrZone(DeliveryInterconnectionPoint1Choice__1 _dlvryPtOrZone) {
			this.dlvryPtOrZone = _dlvryPtOrZone == null ? null : _dlvryPtOrZone.toBuilder();
			return this;
		}
		
		@RosettaAttribute("intrCnnctnPt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("intrCnnctnPt")
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setIntrCnnctnPt(DeliveryInterconnectionPoint1Choice__1 _intrCnnctnPt) {
			this.intrCnnctnPt = _intrCnnctnPt == null ? null : _intrCnnctnPt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ldTp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ldTp")
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setLdTp(EnergyLoadType1Code _ldTp) {
			this.ldTp = _ldTp == null ? null : _ldTp;
			return this;
		}
		
		@RosettaAttribute("dlvryAttr")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dlvryAttr")
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder addDlvryAttr(EnergyDeliveryAttribute10__1 _dlvryAttr) {
			if (_dlvryAttr != null) {
				this.dlvryAttr.add(_dlvryAttr.toBuilder());
			}
			return this;
		}
		
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder addDlvryAttr(EnergyDeliveryAttribute10__1 _dlvryAttr, int idx) {
			getIndex(this.dlvryAttr, idx, () -> _dlvryAttr.toBuilder());
			return this;
		}
		
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder addDlvryAttr(List<? extends EnergyDeliveryAttribute10__1> dlvryAttrs) {
			if (dlvryAttrs != null) {
				for (final EnergyDeliveryAttribute10__1 toAdd : dlvryAttrs) {
					this.dlvryAttr.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("dlvryAttr")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dlvryAttr")
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder setDlvryAttr(List<? extends EnergyDeliveryAttribute10__1> dlvryAttrs) {
			if (dlvryAttrs == null) {
				this.dlvryAttr = new ArrayList<>();
			} else {
				this.dlvryAttr = dlvryAttrs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EnergySpecificAttribute9__1 build() {
			return new EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Impl(this);
		}
		
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder prune() {
			if (dlvryPtOrZone!=null && !dlvryPtOrZone.prune().hasData()) dlvryPtOrZone = null;
			if (intrCnnctnPt!=null && !intrCnnctnPt.prune().hasData()) intrCnnctnPt = null;
			dlvryAttr = dlvryAttr.stream().filter(b->b!=null).<EnergyDeliveryAttribute10__1.EnergyDeliveryAttribute10__1Builder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDlvryPtOrZone()!=null && getDlvryPtOrZone().hasData()) return true;
			if (getIntrCnnctnPt()!=null && getIntrCnnctnPt().hasData()) return true;
			if (getLdTp()!=null) return true;
			if (getDlvryAttr()!=null && getDlvryAttr().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder o = (EnergySpecificAttribute9__1.EnergySpecificAttribute9__1Builder) other;
			
			merger.mergeRosetta(getDlvryPtOrZone(), o.getDlvryPtOrZone(), this::setDlvryPtOrZone);
			merger.mergeRosetta(getIntrCnnctnPt(), o.getIntrCnnctnPt(), this::setIntrCnnctnPt);
			merger.mergeRosetta(getDlvryAttr(), o.getDlvryAttr(), this::getOrCreateDlvryAttr);
			
			merger.mergeBasic(getLdTp(), o.getLdTp(), this::setLdTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergySpecificAttribute9__1 _that = getType().cast(o);
		
			if (!Objects.equals(dlvryPtOrZone, _that.getDlvryPtOrZone())) return false;
			if (!Objects.equals(intrCnnctnPt, _that.getIntrCnnctnPt())) return false;
			if (!Objects.equals(ldTp, _that.getLdTp())) return false;
			if (!ListEquals.listEquals(dlvryAttr, _that.getDlvryAttr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dlvryPtOrZone != null ? dlvryPtOrZone.hashCode() : 0);
			_result = 31 * _result + (intrCnnctnPt != null ? intrCnnctnPt.hashCode() : 0);
			_result = 31 * _result + (ldTp != null ? ldTp.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dlvryAttr != null ? dlvryAttr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnergySpecificAttribute9__1Builder {" +
				"dlvryPtOrZone=" + this.dlvryPtOrZone + ", " +
				"intrCnnctnPt=" + this.intrCnnctnPt + ", " +
				"ldTp=" + this.ldTp + ", " +
				"dlvryAttr=" + this.dlvryAttr +
			'}';
		}
	}
}
