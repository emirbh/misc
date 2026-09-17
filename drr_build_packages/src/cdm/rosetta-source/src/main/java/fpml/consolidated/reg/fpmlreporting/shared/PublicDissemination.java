package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.PublicDisseminationMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Information related to the public dissemination.
 *
 */
@RosettaDataType(value="PublicDissemination", builder=PublicDissemination.PublicDisseminationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PublicDissemination", model="fpml", builder=PublicDissemination.PublicDisseminationBuilderImpl.class, version="2.1.1")
public interface PublicDissemination extends RosettaModelObject {

	PublicDisseminationMeta metaData = new PublicDisseminationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the disseminationId used for public reporting.
	 *
	 */
	DisseminationId getDisseminationId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time the public report was disseminated.
	 *
	 */
	ZonedDateTime getPublicationTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time the public report is projected to be disseminated.
	 *
	 */
	ZonedDateTime getProjectedTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time the public report was withdrawn from the public tape.
	 *
	 */
	ZonedDateTime getWithdrawn();

	/*********************** Build Methods  ***********************/
	PublicDissemination build();
	
	PublicDissemination.PublicDisseminationBuilder toBuilder();
	
	static PublicDissemination.PublicDisseminationBuilder builder() {
		return new PublicDissemination.PublicDisseminationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PublicDissemination> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PublicDissemination> getType() {
		return PublicDissemination.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("disseminationId"), processor, DisseminationId.class, getDisseminationId());
		processor.processBasic(path.newSubPath("publicationTime"), ZonedDateTime.class, getPublicationTime(), this);
		processor.processBasic(path.newSubPath("projectedTime"), ZonedDateTime.class, getProjectedTime(), this);
		processor.processBasic(path.newSubPath("withdrawn"), ZonedDateTime.class, getWithdrawn(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PublicDisseminationBuilder extends PublicDissemination, RosettaModelObjectBuilder {
		DisseminationId.DisseminationIdBuilder getOrCreateDisseminationId();
		@Override
		DisseminationId.DisseminationIdBuilder getDisseminationId();
		PublicDissemination.PublicDisseminationBuilder setDisseminationId(DisseminationId disseminationId);
		PublicDissemination.PublicDisseminationBuilder setPublicationTime(ZonedDateTime publicationTime);
		PublicDissemination.PublicDisseminationBuilder setProjectedTime(ZonedDateTime projectedTime);
		PublicDissemination.PublicDisseminationBuilder setWithdrawn(ZonedDateTime withdrawn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("disseminationId"), processor, DisseminationId.DisseminationIdBuilder.class, getDisseminationId());
			processor.processBasic(path.newSubPath("publicationTime"), ZonedDateTime.class, getPublicationTime(), this);
			processor.processBasic(path.newSubPath("projectedTime"), ZonedDateTime.class, getProjectedTime(), this);
			processor.processBasic(path.newSubPath("withdrawn"), ZonedDateTime.class, getWithdrawn(), this);
		}
		

		PublicDissemination.PublicDisseminationBuilder prune();
	}

	/*********************** Immutable Implementation of PublicDissemination  ***********************/
	class PublicDisseminationImpl implements PublicDissemination {
		private final DisseminationId disseminationId;
		private final ZonedDateTime publicationTime;
		private final ZonedDateTime projectedTime;
		private final ZonedDateTime withdrawn;
		
		protected PublicDisseminationImpl(PublicDissemination.PublicDisseminationBuilder builder) {
			this.disseminationId = ofNullable(builder.getDisseminationId()).map(f->f.build()).orElse(null);
			this.publicationTime = builder.getPublicationTime();
			this.projectedTime = builder.getProjectedTime();
			this.withdrawn = builder.getWithdrawn();
		}
		
		@Override
		@RosettaAttribute("disseminationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationId")
		public DisseminationId getDisseminationId() {
			return disseminationId;
		}
		
		@Override
		@RosettaAttribute("publicationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationTime")
		public ZonedDateTime getPublicationTime() {
			return publicationTime;
		}
		
		@Override
		@RosettaAttribute("projectedTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("projectedTime")
		public ZonedDateTime getProjectedTime() {
			return projectedTime;
		}
		
		@Override
		@RosettaAttribute("withdrawn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawn")
		public ZonedDateTime getWithdrawn() {
			return withdrawn;
		}
		
		@Override
		public PublicDissemination build() {
			return this;
		}
		
		@Override
		public PublicDissemination.PublicDisseminationBuilder toBuilder() {
			PublicDissemination.PublicDisseminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PublicDissemination.PublicDisseminationBuilder builder) {
			ofNullable(getDisseminationId()).ifPresent(builder::setDisseminationId);
			ofNullable(getPublicationTime()).ifPresent(builder::setPublicationTime);
			ofNullable(getProjectedTime()).ifPresent(builder::setProjectedTime);
			ofNullable(getWithdrawn()).ifPresent(builder::setWithdrawn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PublicDissemination _that = getType().cast(o);
		
			if (!Objects.equals(disseminationId, _that.getDisseminationId())) return false;
			if (!Objects.equals(publicationTime, _that.getPublicationTime())) return false;
			if (!Objects.equals(projectedTime, _that.getProjectedTime())) return false;
			if (!Objects.equals(withdrawn, _that.getWithdrawn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (disseminationId != null ? disseminationId.hashCode() : 0);
			_result = 31 * _result + (publicationTime != null ? publicationTime.hashCode() : 0);
			_result = 31 * _result + (projectedTime != null ? projectedTime.hashCode() : 0);
			_result = 31 * _result + (withdrawn != null ? withdrawn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PublicDissemination {" +
				"disseminationId=" + this.disseminationId + ", " +
				"publicationTime=" + this.publicationTime + ", " +
				"projectedTime=" + this.projectedTime + ", " +
				"withdrawn=" + this.withdrawn +
			'}';
		}
	}

	/*********************** Builder Implementation of PublicDissemination  ***********************/
	class PublicDisseminationBuilderImpl implements PublicDissemination.PublicDisseminationBuilder {
	
		protected DisseminationId.DisseminationIdBuilder disseminationId;
		protected ZonedDateTime publicationTime;
		protected ZonedDateTime projectedTime;
		protected ZonedDateTime withdrawn;
		
		@Override
		@RosettaAttribute("disseminationId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("disseminationId")
		public DisseminationId.DisseminationIdBuilder getDisseminationId() {
			return disseminationId;
		}
		
		@Override
		public DisseminationId.DisseminationIdBuilder getOrCreateDisseminationId() {
			DisseminationId.DisseminationIdBuilder result;
			if (disseminationId!=null) {
				result = disseminationId;
			}
			else {
				result = disseminationId = DisseminationId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicationTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationTime")
		public ZonedDateTime getPublicationTime() {
			return publicationTime;
		}
		
		@Override
		@RosettaAttribute("projectedTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("projectedTime")
		public ZonedDateTime getProjectedTime() {
			return projectedTime;
		}
		
		@Override
		@RosettaAttribute("withdrawn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("withdrawn")
		public ZonedDateTime getWithdrawn() {
			return withdrawn;
		}
		
		@RosettaAttribute("disseminationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("disseminationId")
		@Override
		public PublicDissemination.PublicDisseminationBuilder setDisseminationId(DisseminationId _disseminationId) {
			this.disseminationId = _disseminationId == null ? null : _disseminationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publicationTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publicationTime")
		@Override
		public PublicDissemination.PublicDisseminationBuilder setPublicationTime(ZonedDateTime _publicationTime) {
			this.publicationTime = _publicationTime == null ? null : _publicationTime;
			return this;
		}
		
		@RosettaAttribute("projectedTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("projectedTime")
		@Override
		public PublicDissemination.PublicDisseminationBuilder setProjectedTime(ZonedDateTime _projectedTime) {
			this.projectedTime = _projectedTime == null ? null : _projectedTime;
			return this;
		}
		
		@RosettaAttribute("withdrawn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("withdrawn")
		@Override
		public PublicDissemination.PublicDisseminationBuilder setWithdrawn(ZonedDateTime _withdrawn) {
			this.withdrawn = _withdrawn == null ? null : _withdrawn;
			return this;
		}
		
		@Override
		public PublicDissemination build() {
			return new PublicDissemination.PublicDisseminationImpl(this);
		}
		
		@Override
		public PublicDissemination.PublicDisseminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PublicDissemination.PublicDisseminationBuilder prune() {
			if (disseminationId!=null && !disseminationId.prune().hasData()) disseminationId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDisseminationId()!=null && getDisseminationId().hasData()) return true;
			if (getPublicationTime()!=null) return true;
			if (getProjectedTime()!=null) return true;
			if (getWithdrawn()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PublicDissemination.PublicDisseminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PublicDissemination.PublicDisseminationBuilder o = (PublicDissemination.PublicDisseminationBuilder) other;
			
			merger.mergeRosetta(getDisseminationId(), o.getDisseminationId(), this::setDisseminationId);
			
			merger.mergeBasic(getPublicationTime(), o.getPublicationTime(), this::setPublicationTime);
			merger.mergeBasic(getProjectedTime(), o.getProjectedTime(), this::setProjectedTime);
			merger.mergeBasic(getWithdrawn(), o.getWithdrawn(), this::setWithdrawn);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PublicDissemination _that = getType().cast(o);
		
			if (!Objects.equals(disseminationId, _that.getDisseminationId())) return false;
			if (!Objects.equals(publicationTime, _that.getPublicationTime())) return false;
			if (!Objects.equals(projectedTime, _that.getProjectedTime())) return false;
			if (!Objects.equals(withdrawn, _that.getWithdrawn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (disseminationId != null ? disseminationId.hashCode() : 0);
			_result = 31 * _result + (publicationTime != null ? publicationTime.hashCode() : 0);
			_result = 31 * _result + (projectedTime != null ? projectedTime.hashCode() : 0);
			_result = 31 * _result + (withdrawn != null ? withdrawn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PublicDisseminationBuilder {" +
				"disseminationId=" + this.disseminationId + ", " +
				"publicationTime=" + this.publicationTime + ", " +
				"projectedTime=" + this.projectedTime + ", " +
				"withdrawn=" + this.withdrawn +
			'}';
		}
	}
}
